package ac.injecs.java2.config;
import ac.injecs.java2.config.sql.*;
import ac.injecs.java2.entity.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;

public class DBConnect {
	private static DBConnect dbConnect = new DBConnect();

	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/injecm";
	private final String sqlScriptRoot = "./resources/sql/";

	// MySql에 사용하는여러 객체를 만들어줍니다.
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public static DBConnect getInstance() {
		return dbConnect;
	}

	public DBConnect() {
		System.out.print("Inje CM DB 접속 : ");
		try {
			Class.forName(JDBC_DRIVER); // Class 클래스의 forName()함수를 이용해서 해당 클래스를 메모리로 로드 하는 것입니다.

			// URL, ID, password를 입력하여 데이터베이스에 접속합니다.
			connection = DriverManager.getConnection(JDBC_URL, DBUser.USER, DBUser.PASSWORD);

			// 접속결과를 출력합니다.
			if (connection != null) {
				System.out.println("성공");

				setUpDB();
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

	private void setUpDB() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("DB 초기화 후 DB 생성을 합니다. \n진행하시겠습니까? (Y/N)");

		String input = scanner.next();
		if (!input.equals("Y") && !input.equals("y")) {
			System.out.println("DB 초기화를 중단합니다.");
			return;
		}
		System.out.println("DB 초기화를 진행합니다.");
		clearDb();
		createTables();
		createData();
	}

	private void createData() {
		runScript("injecm_data.sql");
	}

	private void createTables() {
		runScript("injecm_tables.sql");
	}

	private void clearDb() {
		runScript("injecm_clear.sql");
	}

	public Object select(String query, SQLMapper sqlMapper) {
		Object object = null;
		try {
			object = sqlMapper.select(connection.prepareStatement(query));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return object;
	}

	public void insert(String query, SQLMapper sqlMapper, Object object) {
		try {
			sqlMapper.insert(connection.prepareStatement(query), object);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(String query, SQLMapper sqlMapper, Object object) {
		try {
			sqlMapper.update(connection.prepareStatement(query), object);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void roomUpdate(String query, RoomMapper sqlMapper, Object object) {
		try {
			sqlMapper.usingUpdate(connection.prepareStatement(query), object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String query, SQLMapper sqlMapper, Object object) {
		try {
			sqlMapper.delete(connection.prepareStatement(query), object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Vector<Door> getDoorinfo(String rinfo) {
		Vector<Door> door = new Vector<Door>();
		try {
			preparedStatement = connection.prepareStatement("select * from door");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Door di = new Door(resultSet.getString(1), resultSet.getString(2), resultSet.getBoolean(3));
				door.add(di);
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("에에러러");
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (Exception e2) {
			}
		}
		return door;
	}

	public Vector<ResInfo> getResinfo(String id) {
		Vector<ResInfo> res = new Vector<ResInfo>();
		String sql = "select * from user where uno='" + id + "'";
		SQLMapper sqlMapper = new UserMapper();
		User user = (User) select(sql, sqlMapper);

		try {
			if (user.isManager()) {
				preparedStatement = connection.prepareStatement("select * from reservation");
			} else
				preparedStatement = connection.prepareStatement("select * from reservation where uno='" + id + "'");

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ResInfo ri = new ResInfo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getBoolean(7));
				res.add(ri);
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("에에러러");
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (Exception e2) {
			}
		}
		return res;
	}

	public void delres(String id, String rinfo) {
		String sql = "delete from reservation where uno=? && rinfo=?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, rinfo);

			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				System.out.println("reservation데이터 삭제 성공!");
			}
			JOptionPane .showMessageDialog(null,"예약이 삭제되었습니다.");

		} catch (Exception e) {
			JOptionPane .showMessageDialog(null,"예약 삭제 오류");
			System.out.println(e);
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (Exception e2) {
			}
		}
	}

	public void resupdate(String id, String rinfo, boolean accept) {
		String sql = "update reservation set accept=? where uno=? && rinfo=?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(2, id);
			preparedStatement.setString(3, rinfo);
			accept = !accept;
			preparedStatement.setBoolean(1, accept);

			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				System.out.println("reservation 예약 수정 성공!");
			}
			JOptionPane.showMessageDialog(null,"예약 승인/거부가 완료되었습니다.");

		} catch (Exception e) {
			JOptionPane .showMessageDialog(null,"예약 승인/거부 오류");
			System.out.println(e);
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (Exception e2) {
			}
		}
	}
}