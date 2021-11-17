package ac.injecs.java2.repository;

import ac.injecs.java2.entity.Student;

import java.util.*;

public class MemoryStudentRepositoryImpl implements StudentRepository {
    private static Map<Long, Student> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Student save(Student student) {
        student.setKey(++sequence);
        store.put(student.getKey(), student);
        System.out.println(student.toString() + "DB 저장");
        return student;
    }

    @Override
    public Optional<Student> findById(String id) {
        return store.values().stream()
                .filter(user -> user.getId().equals(id))
                .findAny();
    }

    @Override
    public Optional<Student> findByName(String name) {
        return store.values().stream()
                .filter(user -> user.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
