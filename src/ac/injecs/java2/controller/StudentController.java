package ac.injecs.java2.controller;

import ac.injecs.java2.config.PasswordEncoder;
import ac.injecs.java2.config.SessionConfig;
import ac.injecs.java2.dto.UserFormDto;
import ac.injecs.java2.entity.User;
import ac.injecs.java2.service.UserService;

import java.util.Optional;

public class StudentController {

    private final UserService userService;

    public StudentController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 전달
    public User signIn(UserFormDto userFormDto){
        User user = null;
        try {
            user = User.createUser(userFormDto);
            userService.saveStudent(user);
        } catch (IllegalStateException e) {
            // 에러 메세지 발생
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        return user;
    }

    public boolean login(SessionConfig session, String id, String password) {
        Optional<User> login = userService.loginUser(id);
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
