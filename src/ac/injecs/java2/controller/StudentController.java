package ac.injecs.java2.controller;

import ac.injecs.java2.dto.StudentFormDto;
import ac.injecs.java2.entity.Student;
import ac.injecs.java2.service.StudentService;

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 회원가입 전달
    public void newStudent(StudentFormDto studentFormDto) {
        // 폼 에러 체크

    }
}
