package ac.injecs.java2.repository;

import ac.injecs.java2.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findByKey(Long key);

    Optional<User> findById(String id);

    Optional<User> findByName(String name);

    List<User> findAll();
}
