package database;

import model.HousingUnit;

public interface IDBHousingUnit {
	HousingUnit findById(int id) throws DataAccessException;
	
	void insertHousingUnit(HousingUnit housing_unit) throws DataAccessException;
}
