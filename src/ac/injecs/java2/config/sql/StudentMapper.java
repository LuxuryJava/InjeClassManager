package ac.injecs.java2.config.sql;

import ac.injecs.java2.entity.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentMapper extends SQLMapper {

    @Override
    public void insert(PreparedStatement preparedStatement, Object object) {
        try {
            Student student = (Student)object;

            this.preparedStatement = preparedStatement;

            preparedStatement.setInt(1, Math.toIntExact(student.getId()));
            preparedStatement.setString(2, student.getPassword());
            preparedStatement.setString(3, student.getName());
            preparedStatement.setString(4, student.getDepartment());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getPhoneNumber());

            int row = preparedStatement.executeUpdate();

            System.out.println("추가된 row : " + row);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object select(PreparedStatement preparedStatement) {
        Student student = null;
        try {

            this.preparedStatement = preparedStatement;

            this.resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                student = new Student();
                student.setId(String.valueOf(resultSet.getInt("sno")));
                student.setPassword(resultSet.getString("spw"));
                student.setName(resultSet.getString("sname"));
                student.setDepartment(resultSet.getString("department"));
                student.setEmail(resultSet.getString("email"));
                student.setPhoneNumber(resultSet.getString("phone"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
