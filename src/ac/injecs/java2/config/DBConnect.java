package ac.injecs.java2.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DBConnect{
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/injecm";
    private final String sqlScriptRoot = "./resources/sql/";

    // MySql에 사용하는여러 객체를 만들어줍니다.
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public DBConnect() {
        System.out.print("Inje CM 접속 : ");
        try {
            Class.forName(JDBC_DRIVER); //Class 클래스의 forName()함수를 이용해서 해당 클래스를 메모리로 로드 하는 것입니다.
            //URL, ID, password를 입력하여 데이터베이스에 접속합니다.
            connection = DriverManager.getConnection(JDBC_URL, DBUser.USER, DBUser.PASSWORD);

            // 접속결과를 출력합니다.
            if (connection != null) {
                System.out.println("성공");
                statement = connection.createStatement();

                System.out.println("Injc CM DB 테이블 생성");
                clearDb();
                createTables();
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

    private void runScript(String scriptFile) {
        ScriptRunner scriptRunner = new ScriptRunner(connection, false, false);

        try {
            scriptRunner.runScript(new BufferedReader(new FileReader(sqlScriptRoot + scriptFile)));
            System.out.println(scriptFile + " SQL Script 실행");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTables() {
        runScript("injecm_tables.sql");
    }

    public void clearDb() {
        runScript("injecm_clear.sql");
    }

    public void queryExecution(String query) throws SQLException {
        statement.executeQuery(query);
    }
}
