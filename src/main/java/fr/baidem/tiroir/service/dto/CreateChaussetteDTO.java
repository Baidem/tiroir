package fr.baidem.tiroir.service.dto;


public class CreateChaussetteDTO {
	

	private String color;

	private String season;

	public CreateChaussetteDTO(String color, String season) {
		this.color = color;
		this.season = season;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}
	
	

}
