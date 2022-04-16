package fr.baidem.tiroir.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.baidem.tiroir.entity.User;
import fr.baidem.tiroir.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getUsers() {
		return userService.findAll();
	}
}
