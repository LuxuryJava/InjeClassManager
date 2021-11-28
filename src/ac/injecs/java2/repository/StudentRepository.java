package ac.injecs.java2.repository;

import ac.injecs.java2.entity.ResInfo;
import ac.injecs.java2.entity.Student;
import java.sql.ResultSet;

import java.util.List;
import java.util.Optional;
import java.util.Vector;

public interface StudentRepository {

    Student save(Student student);

    Optional<Student> findById(Long id);

    Optional<Student> findByName(String name);

    List<Student> findAll();
    void insertres(ResInfo res);

    Vector<ResInfo> getResinfo(String id); 
    void deleteres(String id,String rinfo);
}
