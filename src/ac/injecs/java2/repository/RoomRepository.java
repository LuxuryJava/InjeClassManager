package ac.injecs.java2.repository;

import ac.injecs.java2.entity.Student;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {
    Student save(Student student);

    Optional<Student> findById(Long id);

    Optional<Student> findByName(String name);

    List<Student> findAll();
}
