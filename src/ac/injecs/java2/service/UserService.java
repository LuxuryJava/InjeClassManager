package ac.injecs.java2.service;

import ac.injecs.java2.entity.User;
import ac.injecs.java2.repository.Repository;

import java.util.Optional;

public class UserService {

    private final Repository repository;

    public UserService(Repository repository){
        this.repository = repository;
    }

    // 회원가입
    public User saveStudent(User student) {
        validateDuplicateStudent(student);  // 중복 검사
        return repository.saveUser(student);
    }

    private void validateDuplicateStudent(User user) {
        Optional<User> findStudent = repository.findUserById(user.getId());
        if (!findStudent.isEmpty()) {
            throw new IllegalStateException();
        }
    }

    public Optional<User> loginUser(String id) {
        return repository.findUserById(id);
    }
}
