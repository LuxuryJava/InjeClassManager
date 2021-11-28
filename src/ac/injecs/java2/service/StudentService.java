package ac.injecs.java2.service;

import ac.injecs.java2.entity.Student;
import ac.injecs.java2.repository.Repository;

import java.util.Optional;

public class StudentService {

    private final Repository repository;

    public StudentService(Repository repository){
        this.repository = repository;
    }

    // 회원가입
    public Student saveStudent(Student student) {
        validateDuplicateStudent(student);  // 중복 검사
        return repository.saveStudent(student);
    }

    private void validateDuplicateStudent(Student student) {
        Optional<Student> findStudent = repository.findStudentById(student.getId());
        if (!findStudent.isEmpty()) {
            throw new IllegalStateException();
        }
    }

    public Optional<Student> loginStudent(Long id) {
        return repository.findStudentById(id);
    }
}
