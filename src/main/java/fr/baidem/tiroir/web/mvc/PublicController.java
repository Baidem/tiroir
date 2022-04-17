package fr.baidem.tiroir.web.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import fr.baidem.tiroir.entity.Drawer;
import fr.baidem.tiroir.entity.Sock;
import fr.baidem.tiroir.service.DrawerService;
import fr.baidem.tiroir.service.SockService;

@Controller
public class PublicController {

	@Autowired
	private DrawerService drawerService;
	
	@Autowired
	private SockService sockService;

	@GetMapping("/")
	public ModelAndView index( ) {
		return new ModelAndView("index");
	}
	
	@GetMapping("/drawer-list")
	public ModelAndView drawerList( ) {
		ModelAndView mAV = new ModelAndView("drawers/drawer-list");
		
        mAV.addObject("drawers", drawerService.findAll());

        return mAV;
	}
	
	@GetMapping("/drawer-content/{id}")
	public ModelAndView drawerContent(@PathVariable Long id) {
		ModelAndView mAV = new ModelAndView("drawers/drawer-content");
		Drawer drawer = drawerService.findById(id);
		List<Sock> socks = sockService.findByDrawer(drawer);
				
		mAV.addObject("socks", socks);

        return mAV;
	}
	
	@GetMapping("/create-drawer")
	public ModelAndView createDrawer( ) {
		return new ModelAndView("drawers/create-drawer");
	}
	
	@GetMapping("/sock-list")
	public ModelAndView sockList() {
		ModelAndView mAV = new ModelAndView("drawers/sock-list");
		
        mAV.addObject("socks", sockService.findAll());

        return mAV;
	}
	
	
}
