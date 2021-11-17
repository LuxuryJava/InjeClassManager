package ac.injecs.java2.repository;

import ac.injecs.java2.config.DBConnect;
import ac.injecs.java2.config.sql.StudentMapper;
import ac.injecs.java2.entity.Student;

import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl implements StudentRepository {
    static final DBConnect dbConnect = new DBConnect();

    @Override
    public Student save(Student student) {
        String sql = "insert into student values(?, ?, ?, ?, ?, ?)";
        dbConnect.insert(sql, new StudentMapper(), student);

        return student;
    }

    @Override
    public Optional<Student> findById(String id) {
        String sql = "select * from student where sno like " + id;
        Student find = (Student) dbConnect.select(sql, new StudentMapper());

        return Optional.ofNullable(find);
    }

    @Override
    public Optional<Student> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        return null;
    }
}
