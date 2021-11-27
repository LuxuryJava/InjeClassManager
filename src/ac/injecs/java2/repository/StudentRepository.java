package ac.injecs.java2.repository;

import ac.injecs.java2.entity.ResInfo;
import ac.injecs.java2.entity.Student;
import java.sql.ResultSet;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);

    Optional<Student> findById(Long id);

    Optional<Student> findByName(String name);

    List<Student> findAll();
    void insertres(ResInfo res);

    ResInfo getResinfo(String id); 
}
