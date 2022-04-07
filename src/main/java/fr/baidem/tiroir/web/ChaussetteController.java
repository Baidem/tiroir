package fr.baidem.tiroir.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.baidem.tiroir.entity.Chaussette;
import fr.baidem.tiroir.service.ChaussetteService;
import fr.baidem.tiroir.service.dto.ChaussetteDTO;
import fr.baidem.tiroir.service.dto.CreateChaussetteDTO;

@RestController
@RequestMapping(value="/socks", method=RequestMethod.GET)
public class ChaussetteController {

	@Autowired
	private ChaussetteService chaussetteService;
	
	@GetMapping
	public List<Chaussette> getChaussettes() {
		List<Chaussette> socks = chaussetteService.findAll();
		return socks;
	}
	
//	@PostMapping
//	public ChaussetteDTO create(CreateChaussetteDTO creationDTO) {
//		ChaussetteDTO created = chaussetteService.create(creationDTO);
//		return created;
//	}

	@GetMapping("{id}")
	public Chaussette getSockById(@PathVariable String id) {
		Chaussette chaussette = (Chaussette) chaussetteService.findById(id);
		return chaussette;
	}
}
