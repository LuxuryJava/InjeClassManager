package ac.injecs.java2.service;

import ac.injecs.java2.entity.User;
import ac.injecs.java2.repository.Repository;

import java.util.Optional;

public class ManagerService {

    private final Repository repository;

    public ManagerService(Repository repository) {
        this.repository = repository;
    }


    public Optional<User> loginManger(String id) {
        return repository.findManagerById(id);
    }

}
