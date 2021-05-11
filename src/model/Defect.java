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
}
