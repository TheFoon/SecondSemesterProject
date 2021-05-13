package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.HousingUnit;

public class DBHousingUnit implements IDBHousingUnit {
	
	private static final String FIND_BY_ID = "select * from HousingUnit where id = ?";
	
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
	public HousingUnit findById(int id) throws DataAccessException {
		HousingUnit housing_unit = null;
		try {
			p_stmt.setString(id, FIND_BY_ID);
			ResultSet rs = p_stmt.executeQuery();
			if (rs.next()) {
				housing_unit = buildObject(rs);
			} 
				
			} catch (SQLException e) {
				throw new DataAccessException();
			}
		return null;
	}
}
