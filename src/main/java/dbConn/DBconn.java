package dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/todo_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	public static Connection conn;

	public static Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}
		return conn;
	}

}
