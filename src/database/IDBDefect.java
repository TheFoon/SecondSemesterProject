package database;

import model.Defect;

public interface IDBDefect {
	IDBDefect findById(int id);

	void insertDefect(Defect defect);
}
