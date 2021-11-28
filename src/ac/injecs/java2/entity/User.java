package ac.injecs.java2.entity;

import ac.injecs.java2.config.PasswordEncoder;
import ac.injecs.java2.dto.UserFormDto;

public class User {
    private String id; // key

    private String name;

    private String department;

    private String email;

    private String phoneNumber;

    private String password;

    private boolean isManager;


    public User(){}

    public User(String id, String name, String department, String email, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.isManager = false;
    }

    public String getId() {
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

    public boolean isManager() {
        return isManager;
    }

    public static class Builder{
        private String id; // key

        private String name;

        private String department;

        private String email;

        private String phoneNumber;

        private String password;

        private boolean isManager;

        public Builder id(String id) {
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

        public Builder isManager(boolean state){
            this.isManager = state;
            return this;
        }

        public User build(){
            User student = new User(id, name, department, email, phoneNumber, password);
            return student;
        }
    }
    public User createManager(String id, String name, String password) {
        User user = new Builder()
                .id(id)
                .name(name)
                .password(password)
                .isManager(true)
                .build();
        return user;
    }

    public static User createUser(UserFormDto userFormDto) {
        String password = userFormDto.getPassword();

        User user = new Builder()
                .id(userFormDto.getId())
                .name(userFormDto.getName())
                .department(userFormDto.getDepartment())
                .email(userFormDto.getEmail())
                .phoneNumber(userFormDto.getPhoneNumber())
                .password(password)
                .build();
        return user;
    }


}

