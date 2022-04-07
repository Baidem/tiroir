package fr.baidem.tiroir.service.dto.user;

public class CreateUserDTO {

	private String userName;

	public CreateUserDTO(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
