package ac.injecs.java2.repository;

import ac.injecs.java2.config.DBConnect;
import ac.injecs.java2.config.sql.NoticeMapper;
import ac.injecs.java2.config.sql.UserMapper;
import ac.injecs.java2.entity.Notice;
import ac.injecs.java2.entity.ResInfo;
import ac.injecs.java2.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.Vector;

public class Repository {
    final DBConnect dbConnect = DBConnect.getInstance();

    // --------------- Student ------------------------//
    public User saveUser(User user) {
        String sql = "insert into user values(?, ?, ?, ?, ?, ?, ?)";
        dbConnect.insert(sql, new UserMapper(), user);

        return user;
    }

    public Optional<User> findUserById(String id) {
        String sql = "select * from user where uno like " + id;
        User find = (User) dbConnect.select(sql, new UserMapper());

        return Optional.ofNullable(find);
    }

    public Optional<User> findUserByName(String name) {
        return Optional.empty();
    }

    public List<User> findUserAll() {
        String sql = "select * from student";
        List<User> users = (List<User>) dbConnect.select(sql, new UserMapper());
        return users;
    }

    // --------------- Manager ------------------------//
    // 관리자는 isManager만 true로 주면 되므로 User 위에 메소드를 이용하면 될듯
//    public User saveManager(User manager) {
//        return null;
//    }
//
//    public Optional<User> findManagerById(String id) {
//        String sql = "select * from user where mid like " + id;
//        User find = (User) dbConnect.select(sql, new UserMapper());
//        return Optional.ofNullable(find);
//    }
//
//    public Optional<User> findManagerByName(String name) {
//        return Optional.empty();
//    }
//
//    public List<User> findManagerAll() {
//        return null;
//    }

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
