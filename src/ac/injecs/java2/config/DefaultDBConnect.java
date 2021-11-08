package ac.injecs.java2.config;

import java.sql.*;

public class DefaultDBConnect extends DBUser{
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/injecm";

    public DefaultDBConnect() {
        // MySql에 사용하는여러 객체를 만들어줍니다.
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        System.out.print("Inje CM 접속 : ");
        try {
            Class.forName(JDBC_DRIVER); //Class 클래스의 forName()함수를 이용해서 해당 클래스를 메모리로 로드 하는 것입니다.
            //URL, ID, password를 입력하여 데이터베이스에 접속합니다.
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // 접속결과를 출력합니다.
            if (connection != null) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exection");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
