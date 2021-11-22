package ac.injecs.java2.controller;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.PasswordEncoder;
import ac.injecs.java2.config.SessionConfig;
import ac.injecs.java2.dto.StudentFormDto;
import ac.injecs.java2.entity.Student;
import ac.injecs.java2.service.StudentService;

import java.util.Optional;

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 회원가입 전달
    public Student signIn(StudentFormDto studentFormDto){
        Student student = null;
        try {
            student = Student.createStudent(studentFormDto);
            studentService.saveStudent(student);
        } catch (IllegalStateException e) {
            // 에러 메세지 발생
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        return student;
    }

    public boolean login(SessionConfig session, Long id, String password) {
        Optional<Student> login = studentService.loginStudent(id);
        if (login.isEmpty()) {
            throw new IllegalStateException("가입되지 않은 회원입니다.");

        }
        password = PasswordEncoder.encode(password).get();

        // 입력한 비밀번호 암호화 후 매칭
        if (login.get().getPassword().equals(password)) {
            session.newSession(true, login.get());
            return true;
        }
        return false;
    }
}
