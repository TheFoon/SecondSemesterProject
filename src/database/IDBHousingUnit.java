package database;

import model.HousingUnit;

public interface IDBHousingUnit {
	HousingUnit findById(int id);
}
