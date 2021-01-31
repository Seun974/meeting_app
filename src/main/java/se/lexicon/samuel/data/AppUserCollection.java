package se.lexicon.samuel.data;

import se.lexicon.samuel.model.AppUser;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

//this would be implemented by the interface
public class AppUserCollection implements AppUserDAO{


    @Override
    public Optional<AppUser> findById(String userId) {
        return Optional.empty();
    }

    @Override
    public List<AppUser> findAll() {
        return null;
    }

    @Override
    public AppUser save(AppUser newUser) {
        return null;
    }

    @Override
    public List<AppUser> findMany(Predicate<AppUser> filter) {
        return null;
    }

    @Override
    public Optional<AppUser> findOne(Predicate<AppUser> filter) {
        return Optional.empty();
    }

    @Override
    public AppUser update(AppUser appUser) {
        return null;
    }

    @Override
    public boolean remove(String userId) {
        return false;
    }
}
