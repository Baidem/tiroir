package fr.baidem.tiroir.service.dto.sock;

import fr.baidem.tiroir.entity.Season;
import fr.baidem.tiroir.entity.Style;

public class CreateSockDTO {
	
	private String brand;
	
    private String color;
    
    private int size;

    private Style style;

    private Season season;

	
	public CreateSockDTO(String brand, String color, int size) {
		this.brand = brand;
		this.color = color;
		this.size = size;
	}
	
	public CreateSockDTO(String brand, String color, int size, Style style, Season season) {
		this(brand, color, size);
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

	public int getSize() {
		return size;
	}



	@Override
	public String toString() {
		return "CreateSockDTO [brand=" + brand + ", color=" + color + ", size=" + size + ", style=" + style
				+ ", season=" + season + "]";
	}
	
	
}
