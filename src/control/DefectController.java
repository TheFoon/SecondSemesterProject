package control;

import database.IDBDefect;
import model.Defect;

public class DefectController {
	
	private IDBDefect dbDefect;
	
	public void reportDefect(String type, String description, String room_name) {
		Defect defect = new Defect(type, description, room_name);
		dbDefect.insertDefect(defect);
	}
}
