package fr.baidem.tiroir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.baidem.tiroir.entity.Sock;
import fr.baidem.tiroir.repository.SockRepository;
import fr.baidem.tiroir.service.dto.CreateSockDTO;

@Service
public class SockService {
	
	@Autowired
	private SockRepository sockRepository;
	
	@Transactional
	public List<Sock> findAll() {
		return sockRepository.findAll();
	}
	
	@Transactional
	public List<Sock> findById(String id) {
		return sockRepository.findById(id);
	}
	
	@Transactional
	public List<Sock> findByBrand(String brand) {
		return sockRepository.findByBrand(brand);
	}
	
	@Transactional
	public List<Sock> findByColor(String color) {
		return sockRepository.findByColor(color);
	}
	
	@Transactional
	public List<Sock> findBySize(String size) {
		return sockRepository.findBySize(size);
	}
	
	@Transactional
	public List<Sock> findByStyle(String style) {
		return sockRepository.findByStyle(style);
	}
	
	@Transactional
	public List<Sock> findBySeason(String season) {
		return sockRepository.findBySeason(season);
	}
	
	public void create(CreateSockDTO dto) {
		Sock sock = new Sock(dto.getBrand(), dto.getColor(), dto.getSize(), dto.getStyle(), dto.getSeason());
		sockRepository.save(sock);
	}
	


}
