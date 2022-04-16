package fr.baidem.tiroir.service.dto.drawer;


public class DrawerDTO {
	
	private Long id;

	private String name;
	

	public DrawerDTO() {
		super();
	}

	public DrawerDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    
	
}
