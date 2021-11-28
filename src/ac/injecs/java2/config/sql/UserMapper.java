package ac.injecs.java2.config.sql;

import ac.injecs.java2.entity.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserMapper extends SQLMapper {

    @Override
    public void insert(PreparedStatement preparedStatement, Object object) {
        try {
            User user = (User)object;

            this.preparedStatement = preparedStatement;

            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getDepartment());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setBoolean(7, user.isManager());

            int row = preparedStatement.executeUpdate();

            System.out.println("추가된 row : " + row);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object select(PreparedStatement preparedStatement) {
        User user = null;
        try {
            this.preparedStatement = preparedStatement;
            this.resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = (new User.Builder()
                        .id(resultSet.getString("uno"))
                        .password(resultSet.getString("upw"))
                        .name(resultSet.getString("uname"))
                        .department(resultSet.getString("department"))
                        .email(resultSet.getString("email"))
                        .phoneNumber(resultSet.getString("phone"))
                        .isManager(resultSet.getBoolean("isManager"))
                        .build());
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
