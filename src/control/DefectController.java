package control;

import database.DataAccessException;
import database.IDBDefect;
import model.Defect;

public class DefectController {
	
	private IDBDefect dbDefect;
	
	public void reportDefect(String type, String description, String room_name) throws DataAccessException {
		Defect defect = new Defect(type, description, room_name);
		dbDefect.insertDefect(defect, 0, 0);
	}
}
