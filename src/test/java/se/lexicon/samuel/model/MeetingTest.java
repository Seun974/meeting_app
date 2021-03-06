package se.lexicon.samuel.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class MeetingTest {

    public static final LocalDateTime START = LocalDateTime.parse("2021-01-27T10:00");
    public static final LocalDateTime END = LocalDateTime.parse("2021-01-27T11:00");
    public static final String TOPIC = "test";
    public static final String AGENDA = "Test agenda";
    public static final AppUser ORGANIZER = new AppUser("test", "test123", "Test", "Testsson");
    private Meeting testObject;

    public AppUser createAppUser(){
        AppUser appUser = new AppUser(
                "esvensson", "ashsdj653", "Erik", "Johnsson"
        );
        return appUser;
    }


    //also introduce constant here to take up the fields
    @BeforeEach
    public void setUp() throws Exception{
        testObject = new Meeting(
                START,
                END,
                TOPIC,
                AGENDA,
                ORGANIZER
        );
    }
    @Test
    public void testObjectCreated(){
        assertNotNull(testObject.getMeetingId());
        System.out.println(testObject.getMeetingId());
    }

    @Test
    //this would test the appUser added to the testObject and it will have a corresponding remove appUser
    public void addAppUser() {
        AppUser appUser = createAppUser();

        testObject.addParticipants(appUser);
        assertTrue(testObject.getParticipants().contains(appUser));
        assertTrue(appUser.getMeetings().contains(testObject));

    }

    @Test
    @DisplayName("removes from appUser")
    public void removeAppUser() {
        //arrange
        AppUser appUser = createAppUser();
        testObject.addParticipants(appUser);
        //act
        testObject.removeParticipants(appUser);
        //assert
        assertFalse(testObject.getParticipants().contains(appUser));
        assertFalse(appUser.getMeetings().contains(testObject));


    }
}
