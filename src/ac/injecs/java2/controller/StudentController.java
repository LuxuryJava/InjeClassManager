package ac.injecs.java2.controller;

import ac.injecs.java2.config.PasswordEncoder;
import ac.injecs.java2.dto.StudentFormDto;
import ac.injecs.java2.entity.Student;
import ac.injecs.java2.service.StudentService;

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 회원가입 전달
    public void postSignPanel(StudentFormDto studentFormDto) {
        // TODO : 폼에러체크 하기

        try {
            Student student = Student.createStudent(studentFormDto);
            studentService.saveStudent(student);
        } catch (IllegalStateException e) {
            // 에러 메세지 발생
            System.out.println("IllegalStateException : " + e.getMessage());
        }
    }

    public void getLoginPanel(Long id, String password) {
        studentService.getStudentByLogin(id, password);
    }
}
