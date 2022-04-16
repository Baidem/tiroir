package fr.baidem.tiroir.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.baidem.tiroir.entity.Drawer;
import fr.baidem.tiroir.service.DrawerService;
import fr.baidem.tiroir.service.dto.drawer.CreateDrawerDTO;
import fr.baidem.tiroir.service.dto.drawer.DrawerDTO;

@RestController
@RequestMapping("api/drawers")
public class DrawerController {

	@Autowired
	private DrawerService drawerService;
	 
	@GetMapping
	public List<Drawer> getDrawers() {
		List<Drawer> drawers = drawerService.findAll();
		return drawers;
	}
	
	@PostMapping
	public DrawerDTO create(CreateDrawerDTO creationDTO) {
		DrawerDTO created = drawerService.createDTO(creationDTO);
		return created;
	}
	
	@GetMapping("{id}")
	public Drawer getDrawerById(@PathVariable String id) {
		Drawer drawer = (Drawer) drawerService.findById(id);
		return drawer;
	}
	
	
}
