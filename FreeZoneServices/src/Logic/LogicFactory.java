package Logic;

import java.sql.*;

public class LogicFactory {
	private static final String Driver= "com.mysql.jdbc.Driver";
	private static final String DBURL= "jdbc:mysql://localhost/FreeZoneDB";
	private static final String dbuser= "root";
	private static final String dbpass= "";
	
	public static Connection connection;
	
	public static Connection Connect() throws Exception {
		try {
			Class.forName(Driver);
			connection = DriverManager.getConnection(DBURL, dbuser, dbpass);
			return connection;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void Disconnect() throws Exception {
		try {
			connection.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static TestLogic getTestLogic() {
		return new TestLogic(connection);
	}

}
