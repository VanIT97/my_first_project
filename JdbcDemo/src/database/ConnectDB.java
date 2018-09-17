package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	private static String url="jdbc:sqlserver://localhost:1433;databaseName=SqlDemo2";
	private static String user="sa";
	private static String password="18031995";

	public static Connection getConnecṭ() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (connection == null) {
			try {
				throw new IOException("connection is fail!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

}
