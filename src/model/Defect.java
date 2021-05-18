package model;

public class Defect {
	
	private String type;
	private String description;
	private String room_name;
	
	public Defect(String type, String description, String room_name)
	{
		this.type = type;
		this.description = description;
		this.room_name = room_name;
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

	public String getRoomName() {
		return room_name;
	}

	public void setRoomName(String room_name) {
		this.room_name = room_name;
	}
	
	
}
