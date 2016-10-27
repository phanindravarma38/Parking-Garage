package cs414.a4.phanisag.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static Connection connection;

	public static Connection getConnection() {
		

			// Register the JDBC driver for MySQL.
			try {
				Class.forName("com.mysql.jdbc.Driver");

				// Define URL of database server for
				// database named 'user' on the faure.
				String url = "jdbc:mysql://localhost:8080/phanisag";

				// Get a connection to the database for a
				// user named 'user' with the password
				// 123456789.
				connection = DriverManager.getConnection(url, "phanisag",
						"830779594");

				// Display URL and connection information
				System.out.println("URL: " + url);
				System.out.println("Connection: " + connection);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

		
		return connection;
	}
}
