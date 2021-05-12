package database;

import model.HousingUnit;

public interface HousingUnitDBIF {
	HousingUnit findById(int id);
}
