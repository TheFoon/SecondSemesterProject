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
	public Defect findById(int id) throws DataAccessException, SQLException {
		Defect defect = null;
		String query = "select * from Defect where id = ?";
		
		db_connection = DBConnection.getInstance();
		
		p_stmt = db_connection.getConnection().prepareStatement(query);
		p_stmt.setInt(1, id);
		
		ResultSet rs = p_stmt.executeQuery();
		if(rs.next())
		{
			defect = buildObject(rs);
		}
		return defect;
	}
	private Defect buildObject(ResultSet result_set) throws SQLException
	{
		return new Defect(result_set.getString(1), result_set.getString(2), result_set.getString(3));
	}
}
