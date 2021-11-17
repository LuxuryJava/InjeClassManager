package ac.injecs.java2.config;

import ac.injecs.java2.entity.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Optional;

public class DBConnect{
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/injecm";
    private final String sqlScriptRoot = "./resources/sql/";

    // MySql에 사용하는여러 객체를 만들어줍니다.
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
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

                releasMode();
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

    private void releasMode(){
        System.out.println("Injc CM DB 테이블 생성");
        clearDb();
        createTables();
    }

    private void createTables() {
        runScript("injecm_tables.sql");
    }

    private void clearDb() {
        runScript("injecm_clear.sql");
    }

    public Student studentSelect(String query){
        Student student = null;
        try {
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                student = new Student();
                student.setId(String.valueOf(resultSet.getInt("sno")));
                student.setPassword(resultSet.getString("spw"));
                student.setName(resultSet.getString("sname"));
                student.setDepartment(resultSet.getString("department"));
                student.setEmail(resultSet.getString("email"));
                student.setPhoneNumber(resultSet.getString("phone"));
                System.out.println("DB에 저장된 학생" + student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void studentInsert(String query, Student student){
        try {
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, Integer.parseInt(student.getId()));
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

}
