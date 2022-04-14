package fr.baidem.tiroir.web.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import fr.baidem.tiroir.service.DrawerService;

@Controller
public class PublicController {

	@Autowired
	private DrawerService drawerService;
	
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
	
	@GetMapping("/drawer-content")
	public ModelAndView drawerContent( ) {
		return new ModelAndView("drawers/drawer-content");
	}
	
	@GetMapping("/create-drawer")
	public ModelAndView createDrawer( ) {
		return new ModelAndView("drawers/create-drawer");
	}
	
	@GetMapping("/sock-list")
	public ModelAndView socksList() {
		return new ModelAndView("drawers/sock-list");
	}
	
	
}
