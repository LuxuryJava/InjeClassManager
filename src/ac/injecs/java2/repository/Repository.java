package ac.injecs.java2.repository;

import ac.injecs.java2.config.DBConnect;
import ac.injecs.java2.config.sql.*;
import ac.injecs.java2.entity.*;


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
        String sql = "select * from user where uno like " + "\"" + id + "\"";
        User find = (User) dbConnect.select(sql, new UserMapper());

        return Optional.ofNullable(find);
    }

    public Optional<User> findUserByName(String name) {
        return Optional.empty();
    }

    public List<User> findUserAll() {
        String sql = "select * from user";
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
    	String sql = "insert into reservation values(?,?,?,?,?,?,?)";
        dbConnect.insert(sql, new ReservationMapper(), res);
    }
    public Vector<ResInfo> getResinfo(String id) {
        return dbConnect.getResinfo(id);
    }
    public void deleteres(String id,String rinfo) {
        dbConnect.delres(id,rinfo);
    }
    public void resupdate(String id, String rinfo, boolean accept) {
        dbConnect.resupdate(id, rinfo, accept);
    }

    public List<ResInfo> findReservationAll(){
        String sql = "select * from reservation";
        List<ResInfo> resInfos = (List<ResInfo>) dbConnect.select(sql, new ReservationMapper());
        return resInfos;
    }

    public List<ResInfo> findReservationByUseTime(String usetime) {
        String sql = "select * from reservation where usetime like " + "'" +usetime + "'";
        List<ResInfo> resInfos = (List<ResInfo>) dbConnect.select(sql, new ReservationMapper());
        return resInfos;
    }
    // --------------- Notice ------------------------//

    public Notice insertNotice(Notice notice) {
        String sql = "insert into notification values(?, ?)";
        dbConnect.insert(sql, new NoticeMapper(), notice);
        return notice;
    }
    public List<Notice> findNoticeAll() {
        String sql = "select * from notification";
        List<Notice> notice = (List<Notice>) dbConnect.select(sql, new NoticeMapper());
        return notice;
    }

    public Optional<Notice> findNoticeByTitle(String title){
        String sql = "select * from notification where ntitle like " +"\"" +title + "\"";
        return Optional.ofNullable((Notice)dbConnect.select(sql, new NoticeMapper()));
    }
    
    // --------------- Room ------------------------//
    public Room getRoom(String rinfo) {
        String sql = "select * from room where rinfo like " + "\"" +rinfo + "\"";
        Room room = (Room) dbConnect.select(sql, new RoomMapper());
        return room;
    }

    public List<Room> findRoomAll(){
        String sql = "select * from room";
        List<Room> finds = (List<Room>) dbConnect.select(sql, new RoomMapper());
        return finds;
    }
    
    public void roomupdate(Room room) {
    	String sql = "update room set doorOpen=? where rinfo=?";
        dbConnect.update(sql, new RoomMapper(), room);
    }
    
    // --------------- Door ------------------------//
    public Door insertDoor(Door door) {
        String sql = "insert into door values(?, ?, ?)";
        dbConnect.insert(sql, new DoorMapper(), door);
        return door;
    }
    
//    public Vector<Door> findDoorAll() {
//        String sql = "select * from door";
//        Vector<Door> findDoor = (Vector<Door>) dbConnect.select(sql, new DoorMapper());
//        return findDoor;
//    }
    
    public Vector<Door> getDoorinfo(String rinfo) {
        return dbConnect.getDoorinfo(rinfo);
    }
    
    public void doorupdate(Door door) {
    	String sql = "update door set doorOpen=? where uno=? && rinfo=?";
        dbConnect.update(sql,new DoorMapper(),door);
    }
    
    public void deletedoor(Door door) {
    	String sql = "delete from door where rinfo=?";
        dbConnect.delete(sql, new DoorMapper(), door);
    }
}
