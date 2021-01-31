package se.lexicon.samuel.data;


import se.lexicon.samuel.model.AppUser;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

//everything in an interface is always public so no need for the access keyword public

public interface AppUserDAO {
    Optional<AppUser> findById(String userId);
    List<AppUser> findAll();
    AppUser save(AppUser newUser);
    List<AppUser> findMany(Predicate<AppUser> filter);
    Optional<AppUser> findOne(Predicate<AppUser> filter);
    AppUser update(AppUser appUser);
    boolean remove(String userId);

}
