package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.HousingUnit;

public class DBHousingUnit implements IDBHousingUnit {
	
	private PreparedStatement p_stmt;
	private DBConnection db_connection;
	
	public DBHousingUnit() throws DataAccessException
	{
		db_connection = DBConnection.getInstance();
	}
	
	private HousingUnit buildObject(ResultSet rs) throws SQLException {
		return new HousingUnit(rs.getString(1));
	}

	@Override
	public HousingUnit findById(int id) {
		
		return null;
	}
}
