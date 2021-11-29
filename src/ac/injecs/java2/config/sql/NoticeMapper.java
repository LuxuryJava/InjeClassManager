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

            preparedStatement.setString(2, notice.getTitle());
            preparedStatement.setString(3, notice.getContent());

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
                        .title(resultSet.getString("ntitle"))
                        .content(resultSet.getString("scontent"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notice;
    }
}
