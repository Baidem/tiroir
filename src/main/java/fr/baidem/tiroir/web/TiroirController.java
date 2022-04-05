package fr.baidem.tiroir.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.baidem.tiroir.entity.Tiroir;
import fr.baidem.tiroir.service.TiroirService;

@RestController
@RequestMapping(value="/drawers", method=RequestMethod.GET)
public class TiroirController {
	
	@Autowired
	private TiroirService tiroirService;
	
	@GetMapping
	public List<Tiroir> getTiroirs() {
		return tiroirService.findAll();
	}

}
