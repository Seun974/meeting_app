package se.lexicon.samuel.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

//focus is on testing the add and remove meeting
public class AppUserTest {
    public static final String FIRST_NAME = "Test";
    public static final String LAST_NAME = "Testsson";
    public static final String PASSWORD = "test123";
    public static final String USER_NAME = "test";

    //the fields for the testing different from the constance
    private AppUser testObject;
    private Meeting meeting;

    //this method will be used to instantiate a new meeting or whole meeting
    public Meeting generateMeeting() {
        return new Meeting(
                LocalDateTime.parse("2021-01-27T10:00"),
                LocalDateTime.parse("2021-01-27T11:00"),
                "Test topic", "Test agenda",
                testObject
        );
    }

    @Before
    public void setUp() throws Exception {
        testObject = new AppUser(
                USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME
        );
    }

    @Test
    //this method successfully instantiates the testObject
    public void constructorCreation() {
        assertNotNull(testObject.getUserId());
    }

    @Test
    //with Junit5 use can use @DisplayName and write the title you want here
    //Giving meeting addMeeting adds meeting bidirectional (adds meeting both ways)
    //this method gets a meeting adds it gets the participant
    public void addMeeting() {
        Meeting meeting = generateMeeting();
        testObject.addMeeting(meeting);

        assertTrue(testObject.getMeetings().contains(meeting));
        assertTrue(meeting.getParticipants().contains(testObject));
    }
    @Test
    //Giving meeting addMeeting removes meeting bidirectional (adds meeting both ways)
    //this method takes the opposite implementation of the addMeeting
    public void removeMeeting(){
        Meeting meeting = generateMeeting();

        testObject.addMeeting(meeting);
        testObject.removeMeeting(meeting);

        assertFalse(testObject.getMeetings().contains(meeting));
        assertFalse(meeting.getParticipants().contains(testObject));

    }
}
