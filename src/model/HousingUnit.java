package model;

import java.util.List;

public class HousingUnit {
	private String type;
	private List<Defect> defects;
	private String address;
	
	public HousingUnit(String type) {
		this.setType(type);
	}
	
	private void addDefect(Defect defect) {
		defects.add(defect);
	}
	
	private void deleteDefect(Defect defect) {
		defects.remove(defect);
	}
	
	private void listDefects() {
		defects.forEach(defect -> System.out.println(defect.getType()));
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
