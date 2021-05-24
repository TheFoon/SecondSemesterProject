package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import database.DBDefect;
import database.DataAccessException;
import database.IDBDefect;
import model.Defect;

class TestDBDefect {
	
	private IDBDefect db_defect = null;

	@Test
	void testInsertDefect() throws DataAccessException {
		db_defect = new DBDefect();
		
		Defect defect = new Defect("crack", "crack on the floor", "bathroom");
		db_defect.insertDefect(defect, 1, 1);
		
		assertTrue("Insertion failed, Id not recieved", defect.getId() > 0);
		
		//db_defect.removeById(defect.getId());
	}

}
