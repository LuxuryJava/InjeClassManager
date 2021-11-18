package ac.injecs.java2.service;

import ac.injecs.java2.config.PasswordEncoder;
import ac.injecs.java2.entity.Student;
import ac.injecs.java2.repository.StudentRepository;

import java.util.Optional;
import java.util.OptionalInt;

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

    public void getStudentByLogin(Long id, String password) {
        password = PasswordEncoder.encode(password).get();

        Optional<Student> find = studentRepository.findById(id);
        if (find.isEmpty()) {
            throw new IllegalStateException("가입되지 않은 회원입니다.");
        }

        if (find.get().getPassword().equals(password)) {
            System.out.println("로그인 성공");
        }
        else {
            System.out.println("로그인 실패");
        }
    }
}
