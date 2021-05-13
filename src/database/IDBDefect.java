package database;

import java.sql.SQLException;

import model.Defect;

public interface IDBDefect {
	Defect findById(int id) throws DataAccessException, SQLException;
}
