package ac.injecs.java2.repository;

import ac.injecs.java2.config.DefaultDBConnect;
import ac.injecs.java2.entity.User;

import java.util.List;
import java.util.Optional;

public class DefaultUserRepository implements UserRepository {
    static final DefaultDBConnect dbConnect = new DefaultDBConnect();

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> findByKey(Long key) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
