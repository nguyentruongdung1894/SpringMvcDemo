package usolv.com.vn.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {
	public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String URL = "jdbc:sqlserver://DESKTOP-EB2DNQ0;database=MultipleChoiceApp";
	public static final String USER = "sa";
	public static final String PASS = "Usol12345!";
	
	public static Connection getConnectionSqlServer() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
}
