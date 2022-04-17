package fr.baidem.tiroir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.baidem.tiroir.entity.Drawer;

public interface DrawerRepository extends JpaRepository<Drawer, Long>{
	
	List<Drawer> findById(String id);

	List<Drawer> findByName(String name);
	
}
