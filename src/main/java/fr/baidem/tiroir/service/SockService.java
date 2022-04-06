package fr.baidem.tiroir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.baidem.tiroir.entity.Sock;
import fr.baidem.tiroir.repository.SockRepository;
import fr.baidem.tiroir.service.dto.CreateSockDTO;
import fr.baidem.tiroir.service.dto.SockDTO;

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
	
	public SockDTO createWithEnum(CreateSockDTO creationdto) {
		Sock sock = new Sock(creationdto.getBrand(), creationdto.getColor(), creationdto.getSize(), creationdto.getStyle(), creationdto.getSeason());
		
		sock = this.sockRepository.save(sock);
		
		SockDTO dto = new SockDTO(sock.getId(),sock.getBrand(), sock.getColor(), sock.getSize(), sock.getStyle(), sock.getSeason());
		
		return dto;
	}
	
	public SockDTO create(CreateSockDTO creationdto) {
		Sock sock = new Sock(creationdto.getBrand(), creationdto.getColor(), creationdto.getSize());
		
		sock = this.sockRepository.save(sock);
		
		SockDTO dto = new SockDTO(sock.getId(),sock.getBrand(), sock.getColor(), sock.getSize());
		
		return dto;
	}

}
