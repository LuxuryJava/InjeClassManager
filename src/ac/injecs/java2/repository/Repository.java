package ac.injecs.java2.repository;

import ac.injecs.java2.config.DBConnect;
import ac.injecs.java2.config.sql.MangerMapper;
import ac.injecs.java2.config.sql.NoticeMapper;
import ac.injecs.java2.config.sql.StudentMapper;
import ac.injecs.java2.entity.Manager;
import ac.injecs.java2.entity.Notice;
import ac.injecs.java2.entity.ResInfo;
import ac.injecs.java2.entity.Student;

import javax.swing.text.html.Option;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

public class Repository {
    final DBConnect dbConnect = DBConnect.getInstance();

    // --------------- Student ------------------------//
    public Student saveStudent(Student student) {
        String sql = "insert into student values(?, ?, ?, ?, ?, ?)";
        dbConnect.insert(sql, new StudentMapper(), student);

        return student;
    }

    public Optional<Student> findStudentById(Long id) {
        String sql = "select * from student where sno like " + id;
        Student find = (Student) dbConnect.select(sql, new StudentMapper());

        return Optional.ofNullable(find);
    }

    public Optional<Student> findStudentByName(String name) {
        return Optional.empty();
    }

    public List<Student> findStudentAll() {
        String sql = "select * from student";
        List<Student> students = (List<Student>) dbConnect.select(sql, new StudentMapper());
        return students;
    }

    // --------------- Manager ------------------------//
    public Manager saveManager(Manager manager) {
        return null;
    }

    public Optional<Manager> findManagerById(String id) {
        String sql = "select * from manager where mid like " + id;
        Manager find = (Manager) dbConnect.select(sql, new MangerMapper());
        return Optional.ofNullable(find);
    }

    public Optional<Manager> findManagerByName(String name) {
        return Optional.empty();
    }

    public List<Manager> findManagerAll() {
        return null;
    }

    // --------------- Reservation  ------------------------//

    public void insertres(ResInfo res) {
    	dbConnect.resinsert(res);
    }
    public Vector<ResInfo> getResinfo(String id) {
    	return dbConnect.getResinfo(id);
    }
    public void deleteres(String id,String rinfo) {
    	dbConnect.delres(id,rinfo);
    }

    // --------------- Notice ------------------------//

    public Notice insertNotice(Notice notice) {
        String sql = "insert into student values(?, ?, ?, ?, ?)";
        dbConnect.insert(sql, new NoticeMapper(), notice);

        return notice;
    }

    public List<Notice> findNoticeAll() {
        String sql = "select * from notification";
        List<Notice> notice = (List<Notice>) dbConnect.select(sql, new NoticeMapper());
        return notice;
    }

}
