package fr.baidem.tiroir.service.dto;

public class CreateDrawerDTO {
	
	private String name;

	public CreateDrawerDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
