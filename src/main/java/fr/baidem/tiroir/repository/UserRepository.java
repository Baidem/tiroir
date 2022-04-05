package fr.baidem.tiroir.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.baidem.tiroir.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

		
}
