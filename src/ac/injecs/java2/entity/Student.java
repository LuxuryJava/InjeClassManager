package ac.injecs.java2.entity;

import ac.injecs.java2.config.PasswordEncoder;
import ac.injecs.java2.dto.StudentFormDto;

public class Student {

    private Long id; // key

    private String name;

    private String department;

    private String email;

    private String phoneNumber;

    private String password;

    public Student(){}

    public Student(Long id, String name, String department, String email, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder{
        private Long id; // key

        private String name;

        private String department;

        private String email;

        private String phoneNumber;

        private String password;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Student build(){
            Student student = new Student(id, name, department, email, phoneNumber, password);
            return student;
        }
    }

    public static Student createStudent(StudentFormDto studentFormDto) {
        String password = PasswordEncoder.encode(studentFormDto.getPassword()).get();
        Student student = new Builder()
                .id(studentFormDto.getId())
                .name(studentFormDto.getName())
                .department(studentFormDto.getDepartment())
                .email(studentFormDto.getEmail())
                .phoneNumber(studentFormDto.getPhoneNumber())
                .password(password)
                .build();
        return student;
    }

}
