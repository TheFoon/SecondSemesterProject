package control;

import database.DBDefect;
import database.DataAccessException;
import database.IDBDefect;
import model.Defect;

public class DefectController {
	
	private IDBDefect dbDefect;
	
	public DefectController() {
		try {
			this.dbDefect = new DBDefect();
		} catch (DataAccessException e) {
			System.out.println("There has been an error with the database connection");
		}
	}
	
	public void reportDefect(String type, String description, String room_name) {
		Defect defect = new Defect(type, description, room_name);
		try {
			dbDefect.insertDefect(defect, 0, 0);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
}
