package control;

import database.DBHousingUnit;
import database.DataAccessException;
import database.HousingUnitDBIF;
import model.HousingUnit;

public class HousingUnitController {
	
	HousingUnitDBIF dbHousingUnit;

	public HousingUnitController() throws DataAccessException {
		dbHousingUnit = new DBHousingUnit();
		
	}

	public HousingUnit findById(int id) {
		return dbHousingUnit.findById(id);
	}
}
