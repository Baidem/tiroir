package fr.baidem.tiroir.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.baidem.tiroir.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findById(String id);

	List<User> findByUserName(String userName);	
		
}
