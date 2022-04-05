package fr.baidem.tiroir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.baidem.tiroir.entity.Tiroir;
import fr.baidem.tiroir.repository.TiroirRepository;
import fr.baidem.tiroir.service.dto.CreateTiroirDTO;

@Service
public class TiroirService {

	@Autowired
	private TiroirRepository tiroirRepository;
	
	@Transactional
	public List<Tiroir> findAll() {
		return tiroirRepository.findAll();
	}
	
	@Transactional
	public List<Tiroir> findById(String id) {
		return tiroirRepository.findById(id);
	}
	
	@Transactional
	public List<Tiroir> findByName(String name) {
		return tiroirRepository.findByName(name);
	}

	public void create(CreateTiroirDTO dto) {
		Tiroir tiroir = new Tiroir(dto.getName());
		tiroirRepository.save(tiroir);
	}

}