package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private Connection connection = null;
	private static DBConnection dbConnection;
	
	private static String databaseName = "dmai0920_1086316"; // dmai0920_1086316
	private static String serverAddress = "hildur.ucn.dk"; // hildur.ucn.dk
	private static int serverPort = 1433;
	private static String userName = "dmai0920_1086316"; // dmai0920_1086316
	private static String password = "Password1!"; // Password1!
	
	private DBConnection() throws DataAccessException {
		String connectionUrl = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s", 
				serverAddress, serverPort, databaseName, userName, password);
		
		try {
			connection = DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			throw new DataAccessException(String.format("Could not connect to database %s@%s:%d user %s", databaseName,
					serverAddress, serverPort, userName), e);
		}
	}
	
	public static void setConnectionInfo(String dbName, String srvAddress, int srvPort, String uName, String pswd) {
		databaseName = dbName;
		serverAddress = srvAddress;
		serverPort = srvPort;
		userName = uName;
		password = pswd;
	}
	
	public static synchronized DBConnection getInstance() throws DataAccessException {
		if(dbConnection == null) {
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void disconnect() {
		try {
			connection.close();
			dbConnection = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}