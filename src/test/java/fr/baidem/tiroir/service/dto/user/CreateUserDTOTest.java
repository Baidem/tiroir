package fr.baidem.tiroir.service.dto.user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.baidem.tiroir.entity.User;
import fr.baidem.tiroir.service.UserService;

@SpringBootTest
class CreateUserDTOTest {
	
	@Autowired
	private UserService userService;

	@Test
	void testCreateUserDTO() {
		CreateUserDTO dto = new CreateUserDTO("User name test");
		userService.create(dto);
		List<User> users = userService.findByUserName("User name test");
		boolean userNameIsFound = false;
		
		for (User user : users) {
			if (user.getUserName().equals("User name test")) {
				userNameIsFound = true;
			}
		}
		assertTrue(userNameIsFound, "user is not found");
	
	}

}
