package fr.baidem.tiroir.service.dto;

import java.util.UUID;

public class ChaussetteDTO {
	
	private UUID id;
	
	private String color;

	private String season;

	public ChaussetteDTO(UUID id, String color, String season) {
		this.id = id;
		this.color = color;
		this.season = season;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
