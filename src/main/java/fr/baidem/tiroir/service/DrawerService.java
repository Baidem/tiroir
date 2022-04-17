package fr.baidem.tiroir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event.ID;

import fr.baidem.tiroir.entity.Drawer;
import fr.baidem.tiroir.repository.DrawerRepository;
import fr.baidem.tiroir.service.dto.drawer.CreateDrawerDTO;
import fr.baidem.tiroir.service.dto.drawer.DrawerDTO;

@Service
public class DrawerService {
	
	@Autowired
	private DrawerRepository drawerRepository;
	
	
	@Transactional
	public List<Drawer> findAll() {
		return drawerRepository.findAll();
	}
	
	@Transactional
	public Drawer findById(Long id) {
		Drawer findedDrawer = null;
		List<Drawer> allDrawers = drawerRepository.findAll();
		for (Drawer drawer : allDrawers) {
			if (drawer.getId() == id) {
				findedDrawer = drawer;
			}
		}
		return findedDrawer;
	}
	
	@Transactional
	public List<Drawer> findByName(String name) {
		return drawerRepository.findByName(name);
	}
	@Transactional
	public void create(CreateDrawerDTO dto) {
		Drawer drawer = new Drawer(dto.getName());
		drawerRepository.save(drawer);
	}

	@Transactional
	public DrawerDTO createDTO(CreateDrawerDTO creationDTO) {
		Drawer drawer = new Drawer(creationDTO.getName());
		drawerRepository.save(drawer);
		
		DrawerDTO dto = new DrawerDTO();

        BeanUtils.copyProperties(drawer, dto);

        return dto;
	}
	

}
