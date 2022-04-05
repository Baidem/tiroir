package fr.baidem.tiroir.service.dto;

import fr.baidem.tiroir.entity.Season;
import fr.baidem.tiroir.entity.Style;

public class SockDTO {

	private Long id;
	
	private String brand;
	
    private String color;

    private Style style;

    private Season season;

	public SockDTO(Long id, String brand, String color, Style style, Season season) {
		this.id = id;
		this.brand = brand;
		this.color = color;
		this.style = style;
		this.season = season;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
