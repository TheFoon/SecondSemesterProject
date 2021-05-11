package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.HousingUnit;

public class DBHousingUnit implements IDBHousingUnit {
	
	private HousingUnit buildObject(ResultSet rs) throws SQLException {
		return new HousingUnit(rs.getString(1));
	}

	@Override
	public HousingUnit findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
