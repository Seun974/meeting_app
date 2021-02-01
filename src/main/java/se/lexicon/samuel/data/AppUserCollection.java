package se.lexicon.samuel.data;

import se.lexicon.samuel.model.AppUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//this would be implemented by the interface
public class AppUserCollection implements AppUserDAO{
    //Singleton - pattern from the book Design patterns
    //code line 17 to 29

    //storing the only instance of a field.. remember to instantiate

    private static final AppUserCollection INSTANCE;

    //this helps us create our ONLY AppUserCollection object
    static { //this will do the initialization
        INSTANCE = new AppUserCollection();
    }
    //to instantiate whatever we need
    private AppUserCollection(){
        appUsers = new ArrayList<>();
    }
    private List<AppUser> appUsers;

    public static AppUserDAO getInstance(){
        return INSTANCE;
    }

    @Override
    public Optional<AppUser> findById(String userId) {
        return appUsers.stream()
                .filter(appUser -> appUser.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public List<AppUser> findAll() {
        return new ArrayList<>(appUsers);
    }

    @Override
    public AppUser save(AppUser newUser) {
       if(appUsers.contains(newUser)){
           appUsers.add(newUser);
       } else{
           return update(newUser);
       }
        return newUser;
    }

    @Override
    public List<AppUser> findMany(Predicate<AppUser> filter) {
        return appUsers.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AppUser> findOne(Predicate<AppUser> filter) {
        return appUsers.stream()
                .filter(filter)
                .findFirst();
    }

    @Override
    public AppUser update(AppUser appUser) {
        return appUser;
    }

    @Override
    public boolean remove(String userId) {
        AppUser appUser = findById(userId)
                .orElseThrow(() -> new RuntimeException("Couldn't find user with Id " + userId));

        return appUsers.remove(appUser);
    }

    //database needs this clear method. It empties it after each test
    @Override
    public void clear(){
        appUsers.clear();
    }
}
