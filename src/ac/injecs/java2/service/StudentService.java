package ac.injecs.java2.service;

import ac.injecs.java2.entity.Student;
import ac.injecs.java2.repository.StudentRepository;

import java.util.Optional;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    // 회원가입
    public Student saveStudent(Student student) {
        validateDuplicateStudent(student);  // 중복 검사
        return studentRepository.save(student);
    }

    private void validateDuplicateStudent(Student student) {
        Optional<Student> findStudent = studentRepository.findById(student.getId());
        if (!findStudent.isEmpty()) {
            throw new IllegalStateException("이미 가입된 회원입니다");
        }
    }

}
