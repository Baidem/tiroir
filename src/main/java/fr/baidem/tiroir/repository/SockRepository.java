package fr.baidem.tiroir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.baidem.tiroir.entity.Drawer;
import fr.baidem.tiroir.entity.Sock;

public interface SockRepository extends JpaRepository<Sock, Long>{

	List<Sock> findById(String id);
	
	List<Sock> findByBrand(String brand);

	List<Sock> findByColor(String color);
	
	List<Sock> findBySize(String size);

	List<Sock> findByStyle(String style);

	List<Sock> findBySeason(String season);
	
	List<Sock> findByDrawer(Drawer drawer);

}
