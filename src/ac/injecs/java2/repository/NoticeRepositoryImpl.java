package ac.injecs.java2.repository;

import ac.injecs.java2.config.DBConnect;
import ac.injecs.java2.config.sql.NoticeMapper;
import ac.injecs.java2.config.sql.StudentMapper;
import ac.injecs.java2.entity.Notice;
import ac.injecs.java2.entity.Student;

import java.util.List;
import java.util.Optional;

public class NoticeRepositoryImpl  implements NoticeRepository {
    static final DBConnect dbConnect = new DBConnect();

    @Override
    public Notice insert(Notice notice) {
        String sql = "insert into student values(?, ?, ?, ?, ?)";

        return notice;
    }
}
