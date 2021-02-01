package se.lexicon.samuel.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.samuel.model.AppUser;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class AppUserCollectionTest {
    //this will test the singleton
    private AppUserDAO testObject = AppUserDAO.getInstance();
    private AppUser appUser;
    private String userId;

    @BeforeEach
    void setUp() {
        testObject.clear();
        appUser = new AppUser(
            "nisse", "1234", "Nils", "Nilsson"
        );
        userId = appUser.getUserId();
        testObject.save(appUser);
    }

    @Test
    @DisplayName("Given userId findById should return optional with appUser with")
    void findById() {
        Optional<AppUser> result = testObject.findById(userId);

        assertTrue(result.isPresent());
        assertEquals(userId, result.get().getUserId());
    }

    @Test
    @DisplayName("findAll return List Size 1")
    void findAll(){
        assertEquals(1, testObject.findAll().size());
    }

    @Test
    @DisplayName("given new ApUser save successfully persist AppUser")
    void save() {
        AppUser newAppUser = new AppUser(
                "andreas_mangs", "1234", "Andreas", "mangs"
        );

        testObject.save(newAppUser);

        assertTrue(testObject.findById(newAppUser.getUserId()).isPresent());
    }
}
