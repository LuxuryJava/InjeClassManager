package ac.injecs.java2.repository;

import ac.injecs.java2.config.DBConnect;
import ac.injecs.java2.config.sql.StudentMapper;
import ac.injecs.java2.entity.ResInfo;
import ac.injecs.java2.entity.Student;

import javax.swing.text.html.Option;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

public class StudentRepositoryImpl implements StudentRepository {
    final DBConnect dbConnect = DBConnect.getInstance();

    @Override
    public Student save(Student student) {
        String sql = "insert into user values(?, ?, ?, ?, ?, ?)";
        dbConnect.insert(sql, new StudentMapper(), student);

        return student;
    }

    @Override
    public Optional<Student> findById(Long id) {
        String sql = "select * from user where sno like " + id;
        Student find = (Student) dbConnect.select(sql, new StudentMapper());

        return Optional.ofNullable(find);
    }

    @Override
    public Optional<Student> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        String sql = "select * from user";
        List<Student> students = (List<Student>) dbConnect.select(sql, new StudentMapper());
        return students;
    }
    public void insertres(ResInfo res) {
    	dbConnect.resinsert(res);
    }
    public Vector<ResInfo> getResinfo(String id) {
    	return dbConnect.getResinfo(id);
    }
    public void deleteres(String id,String rinfo) {
    	dbConnect.delres(id,rinfo);
    }
}
