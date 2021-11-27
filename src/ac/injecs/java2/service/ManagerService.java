package ac.injecs.java2.service;

import ac.injecs.java2.entity.Manager;
import ac.injecs.java2.repository.ManagerRepository;
import ac.injecs.java2.repository.StudentRepository;

import java.util.Optional;

public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }


    public Optional<Manager> loginManger(String id) {
        return managerRepository.findById(id);
    }

}
