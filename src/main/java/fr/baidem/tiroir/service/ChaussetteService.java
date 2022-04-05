package fr.baidem.tiroir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.baidem.tiroir.entity.Chaussette;
import fr.baidem.tiroir.repository.ChaussetteRepository;
import fr.baidem.tiroir.service.dto.ChaussetteDTO;
import fr.baidem.tiroir.service.dto.CreateChaussetteDTO;

@Service
public class ChaussetteService {
	
	@Autowired
	private ChaussetteRepository chaussetteRepository;
	
	@Transactional
	public List<Chaussette> findAll() {
		return chaussetteRepository.findAll();
	}
	
	@Transactional
	public List<Chaussette> findById(String id) {
		return chaussetteRepository.findById(id);
	}
	
	@Transactional
	public List<Chaussette> findByColor(String color) {
		return chaussetteRepository.findByColor(color);
	}
	
	@Transactional
	public List<Chaussette> findBySeason(String season) {
		return chaussetteRepository.findBySeason(season);
	}
	
	public ChaussetteDTO create(CreateChaussetteDTO creationdto) {
		Chaussette chaussette = new Chaussette(creationdto.getColor(),creationdto.getSeason());
		
		chaussette = this.chaussetteRepository.save(chaussette);
		
		ChaussetteDTO dto = new ChaussetteDTO(chaussette.getId(),chaussette.getColor(), chaussette.getSeason());
		
		return dto;
	}
	
	
}