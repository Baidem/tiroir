package fr.baidem.tiroir.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import fr.baidem.tiroir.entity.Chaussette;

@Repository
public interface ChaussetteRepository extends JpaRepository<Chaussette, UUID> {
		
	List<Chaussette> findById(String id);
	
	List<Chaussette> findByColor(String color);
	
	List<Chaussette> findBySeason(String season);

	List<Chaussette> findByDrawer(String drawer);
	
	
	

}
