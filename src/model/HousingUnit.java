package model;

import java.util.List;

public class HousingUnit {
	private String type;
	private List<Defect> defects;
	
	public HousingUnit(String type) {
		this.setType(type);
	}
	
	private void addDefect(Defect defect) {
		defects.add(defect);
	}
	
	private void deleteDefect(Defect defect) {
		defects.delete(defect);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
