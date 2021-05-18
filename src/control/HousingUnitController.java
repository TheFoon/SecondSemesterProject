package control;

import database.DBHousingUnit;
import database.DataAccessException;
import database.IDBHousingUnit;
import model.HousingUnit;

public class HousingUnitController {
	
	IDBHousingUnit dbHousingUnit;

	public HousingUnitController() throws DataAccessException {
		dbHousingUnit = new DBHousingUnit();
		
	}

	public HousingUnit findById(int id) throws DataAccessException {
		return dbHousingUnit.findById(id);
	}
}
