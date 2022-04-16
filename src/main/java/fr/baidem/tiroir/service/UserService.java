package fr.baidem.tiroir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.baidem.tiroir.entity.User;
import fr.baidem.tiroir.repository.UserRepository;
import fr.baidem.tiroir.service.dto.user.CreateUserDTO;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Transactional
	public List<User> findById(String id) {
		return userRepository.findById(id);
	}
	
	@Transactional
	public List<User> findByUserName(String name) {
		return userRepository.findByUserName(name);
	}

	public void create(CreateUserDTO dto) {
		User user = new User(dto.getUserName());
		userRepository.save(user);
	}
	
}
