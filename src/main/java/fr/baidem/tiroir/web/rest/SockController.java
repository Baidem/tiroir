package fr.baidem.tiroir.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.baidem.tiroir.entity.Sock;
import fr.baidem.tiroir.service.SockService;
import fr.baidem.tiroir.service.dto.sock.CreateSockDTO;
import fr.baidem.tiroir.service.dto.sock.SockDTO;

@RestController
@RequestMapping("api/socks")
public class SockController {
	
	@Autowired
	private SockService sockService;
	
	@GetMapping
	public List<Sock> getSocks() {
		List<Sock> socks = sockService.findAll();
		return socks;
	}
	
	@PostMapping
	public SockDTO create(CreateSockDTO creationDTO) {
		SockDTO created = sockService.createDTO(creationDTO);
		return created;
	}
	
	@GetMapping("{id}")
	public Sock getSockById(@PathVariable String id) {
		Sock sock = (Sock) sockService.findById(id);
		return sock;
	}

}
