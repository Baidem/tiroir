package fr.baidem.tiroir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.baidem.tiroir.entity.Drawer;
import fr.baidem.tiroir.repository.DrawerRepository;
import fr.baidem.tiroir.service.dto.CreateDrawerDTO;

@Service
public class DrawerService {
	@Autowired
	private DrawerRepository drawerRepository;
	
	@Transactional
	public List<Drawer> findAll() {
		return drawerRepository.findAll();
	}
	
	@Transactional
	public List<Drawer> findById(String id) {
		return drawerRepository.findById(id);
	}
	
	@Transactional
	public List<Drawer> findByName(String name) {
		return drawerRepository.findByName(name);
	}

	public void create(CreateDrawerDTO dto) {
		Drawer drawer = new Drawer(dto.getName());
		drawerRepository.save(drawer);
	}

}
