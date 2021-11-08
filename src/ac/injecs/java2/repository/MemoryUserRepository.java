package ac.injecs.java2.repository;

import ac.injecs.java2.entity.User;

import java.util.*;

public class MemoryUserRepository implements UserRepository {
    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public User save(User user) {
        user.setKey(++sequence);
        store.put(user.getKey(), user);
        System.out.println(user.toString() + "DB 저장");
        return user;
    }
    @Override
    public Optional<User> findByKey(Long key) {
        return Optional.ofNullable(store.get(key));
    }

    @Override
    public Optional<User> findById(String id) {
        return store.values().stream()
                .filter(user -> user.getId().equals(id))
                .findAny();
    }

    @Override
    public Optional<User> findByName(String name) {
        return store.values().stream()
                .filter(user -> user.getName().equals(name))
                .findAny();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
