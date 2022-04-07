package fr.baidem.tiroir.service.dto;

import fr.baidem.tiroir.entity.Tiroir;

public class CreateChaussetteDTO {
	

	private String color;

	private String season;
	
	private Tiroir drawer;
 

	public CreateChaussetteDTO(String color, String season) {
		this.color = color;
		this.season = season;
	}
	
	public CreateChaussetteDTO(String color, String season, Tiroir drawer) {
		this(color, season);
		this.drawer = drawer;
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

	public Tiroir getDrawer() {
		return drawer;
	}

	public void setDrawer(Tiroir drawer) {
		this.drawer = drawer;
	}
	
	

}
