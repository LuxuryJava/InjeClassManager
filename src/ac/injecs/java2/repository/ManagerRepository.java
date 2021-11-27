package ac.injecs.java2.repository;

import ac.injecs.java2.entity.Manager;
import ac.injecs.java2.entity.Student;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository {
    Manager save(Manager manager);

    Optional<Manager> findById(String id);

    Optional<Manager> findByName(String name);

    List<Manager> findAll();

}
