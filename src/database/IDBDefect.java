package database;


import java.sql.SQLException;
import model.Defect;

public interface IDBDefect {
	Defect findById(int id) throws DataAccessException, SQLException;

	void insertDefect(Defect defect, int housing_unit_id, int cleaner_id) throws DataAccessException;
}
