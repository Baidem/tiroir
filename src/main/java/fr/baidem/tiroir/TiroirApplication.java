package fr.baidem.tiroir;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import fr.baidem.tiroir.entity.Drawer;
import fr.baidem.tiroir.entity.Season;
import fr.baidem.tiroir.entity.Style;
import fr.baidem.tiroir.entity.Tiroir;

import fr.baidem.tiroir.service.DrawerService;
import fr.baidem.tiroir.service.SockService;
import fr.baidem.tiroir.service.TiroirService;
import fr.baidem.tiroir.service.dto.CreateDrawerDTO;
import fr.baidem.tiroir.service.dto.CreateSockDTO;
import fr.baidem.tiroir.service.dto.CreateTiroirDTO;

@SpringBootApplication
public class TiroirApplication {

	@Autowired
	private TiroirService tiroirService;
	
	@Autowired
	private DrawerService drawerService;

	@Autowired
	private SockService sockService;

	public static void main(String[] args) {
		SpringApplication.run(TiroirApplication.class, args);
	}

	@EventListener(classes = { ApplicationStartedEvent.class })
	public void applicationStarted() {
		System.out.println("Application started");
		List<Tiroir> tiroirs = tiroirService.findAll();
		System.out.println(tiroirs.size() + " Tiroir trouvés");

		if (tiroirs.size() == 0) {
			CreateTiroirDTO dto = new CreateTiroirDTO("tiroir du haut");
			this.tiroirService.create(dto);
			tiroirs = tiroirService.findAll();
			System.out.println(tiroirs.size() + " création du tiroir du haut");

			CreateTiroirDTO dto2 = new CreateTiroirDTO("tiroir du bas");
			this.tiroirService.create(dto2);
			tiroirs = tiroirService.findAll();
			System.out.println(tiroirs.size() + " création du tiroir du bas");
			
		}
		
		List<Drawer> drawers = drawerService.findAll();
		System.out.println(drawers.size() + " drawer(s) find");

		if (drawers.size() == 0) {
			CreateDrawerDTO dto = new CreateDrawerDTO("top drawer");
			this.drawerService.create(dto);
			drawers = drawerService.findAll();
			System.out.println(drawers.size() + " top drawer created");

			CreateDrawerDTO dto2 = new CreateDrawerDTO("bottom drawer");
			this.drawerService.create(dto2);
			drawers = drawerService.findAll();
			System.out.println(drawers.size() + " bottom drawer created");
			
		}
		
		CreateSockDTO dto = new CreateSockDTO("test brand", "test color", 42, Style.SPORT_SHORT, Season.SUMMER);
		System.out.println(dto.toString());
		this.sockService.create(dto);
		System.out.println(drawers.size() + " test sock create");


		
	}

}
