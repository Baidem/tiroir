package fr.baidem.tiroir.service.dto;

public class CreateTiroirDTO {
	
	private String name;

	public CreateTiroirDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
