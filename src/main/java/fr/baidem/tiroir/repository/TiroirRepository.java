package fr.baidem.tiroir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import fr.baidem.tiroir.entity.Tiroir;


@Repository
public interface TiroirRepository extends JpaRepository<Tiroir, Integer>{
		
	List<Tiroir> findById(String id);
	
	List<Tiroir> findByName(String name);
	
	
		
}
