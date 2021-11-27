package ac.injecs.java2.config.sql;

import ac.injecs.java2.entity.Notice;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NoticeMapper extends SQLMapper {
    @Override
    public void insert(PreparedStatement preparedStatement, Object object) {
        try {
            Notice notice = (Notice)object;

            this.preparedStatement = preparedStatement;

            preparedStatement.setInt(1, Math.toIntExact(notice.getId()));
            preparedStatement.setString(2, notice.getTitle());
            preparedStatement.setString(3, notice.getContent());
            preparedStatement.setString(4, notice.getWriter());
            //preparedStatement.setString(5, notice.getCreatedTime());

            int row = preparedStatement.executeUpdate();

            System.out.println("추가된 row : " + row);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object select(PreparedStatement preparedStatement) {
        Notice notice = null;
        try {
            this.preparedStatement = preparedStatement;
            this.resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                notice = (new Notice.Builder()
                        .id((long) resultSet.getInt("nno"))
                        .title(resultSet.getString("ntitle"))
                        .writer(resultSet.getString("nwriter"))
                        .content(resultSet.getString("scontent"))
                        .createdTime(resultSet.getString("ntime"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notice;
    }
}
