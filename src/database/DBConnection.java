package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection dbConnection;

	private final static String host = "localhost";
	private final static String dbName = "knk?useSSL=false";
	private final static String username = "root";
	private final static String password = "1234";

	public static Connection getConnection() {
		if (dbConnection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbConnection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + dbName, username, password);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return dbConnection;
	}

}
