package database;

import java.sql.*;

import model.Defect;

public class DBDefect implements IDBDefect{
	private PreparedStatement p_stmt;
	private DBConnection db_connection;
	public DBDefect() throws DataAccessException
	{
		db_connection = DBConnection.getInstance();
	}
	@Override
	public DBDefect findById(int id) {
		return null;
	}
	private Defect buildObject(ResultSet result_set) throws SQLException
	{
		return new Defect(result_set.getString(1), result_set.getString(2), result_set.getString(3));
	}
}
