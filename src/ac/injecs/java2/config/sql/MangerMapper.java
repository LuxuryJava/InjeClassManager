package ac.injecs.java2.config.sql;

import ac.injecs.java2.entity.Manager;
import ac.injecs.java2.entity.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MangerMapper extends SQLMapper {
    @Override
    public void insert(PreparedStatement preparedStatement, Object object) {
        try {
            Manager manager = (Manager)object;

            this.preparedStatement = preparedStatement;

            preparedStatement.setString(1, manager.getId());
            preparedStatement.setString(2, manager.getPassword());
            preparedStatement.setString(3, manager.getName());

            int row = preparedStatement.executeUpdate();

            System.out.println("추가된 row : " + row);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object select(PreparedStatement preparedStatement) {
        Manager manager = null;
        try {
            this.preparedStatement = preparedStatement;
            this.resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                manager = new Manager(resultSet.getString("mid"),
                        resultSet.getString("mpw"),
                        resultSet.getString("mname")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }
}
