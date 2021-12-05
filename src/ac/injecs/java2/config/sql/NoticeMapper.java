package ac.injecs.java2.config.sql;

import ac.injecs.java2.entity.Notice;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeMapper extends SQLMapper {
    @Override
    public void insert(PreparedStatement preparedStatement, Object object) {
        try {
            Notice notice = (Notice)object;
            this.preparedStatement = preparedStatement;

            preparedStatement.setString(1, notice.getTitle());
            preparedStatement.setString(2, notice.getContent());

            int row = preparedStatement.executeUpdate();

            System.out.println("추가된 row : " + row);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object select(PreparedStatement preparedStatement) {
        List<Notice> notice = new ArrayList<>();
        try {
            this.preparedStatement = preparedStatement;
            this.resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                notice.add((new Notice.Builder()
                        .title(resultSet.getString("ntitle"))
                        .content(resultSet.getString("ncontent"))
                        .build()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(notice.size() == 1){
            return notice.get(0);
        }
        if(notice.size() == 0){
            return null;
        }
        return notice;
    }
}
