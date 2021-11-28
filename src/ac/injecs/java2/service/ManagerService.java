package ac.injecs.java2.service;

import ac.injecs.java2.entity.Manager;
import ac.injecs.java2.repository.Repository;

import java.util.Optional;

public class ManagerService {

    private final Repository repository;

    public ManagerService(Repository repository) {
        this.repository = repository;
    }


    public Optional<Manager> loginManger(String id) {
        return repository.findManagerById(id);
    }

}
