package fr.baidem.tiroir.service.dto.sock;

import fr.baidem.tiroir.entity.Season;
import fr.baidem.tiroir.entity.Style;

public class SockDTO {

	private Long id;
	
	private String brand;
	
    private String color;
    
    private int size;

    private Style style;

    private Season season;

	public SockDTO(Long id, String brand, String color, int size) {
		this.id = id;
		this.brand = brand;
		this.color = color;
		this.size = size;
	}
	
	public SockDTO(Long id, String brand, String color, int size, Style style, Season season) {
		this(id, brand, color, size);
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
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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
