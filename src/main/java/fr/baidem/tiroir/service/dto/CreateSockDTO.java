package fr.baidem.tiroir.service.dto;

import fr.baidem.tiroir.entity.Season;
import fr.baidem.tiroir.entity.Style;

public class CreateSockDTO {
	
	private String brand;
	
    private String color;

    private Style style;

    private Season season;

	public CreateSockDTO(String brand, String color, Style style, Season season) {
		this.brand = brand;
		this.color = color;
		this.style = style;
		this.season = season;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

    
	
}
