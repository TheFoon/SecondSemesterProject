package model;

public class Defect {
	
	private String type;
	private String description;
	private String room_number;
	
	public Defect(String type, String description, String room_number)
	{
		this.type = type;
		this.description = description;
		this.room_number = room_number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoom_number() {
		return room_number;
	}

	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	
	
}
