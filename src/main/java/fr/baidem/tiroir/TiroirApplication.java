package fr.baidem.tiroir;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import fr.baidem.tiroir.entity.Drawer;
import fr.baidem.tiroir.entity.Season;
import fr.baidem.tiroir.entity.Sock;
import fr.baidem.tiroir.entity.Style;
import fr.baidem.tiroir.repository.SockRepository;
import fr.baidem.tiroir.service.DrawerService;
import fr.baidem.tiroir.service.SockService;
import fr.baidem.tiroir.service.dto.drawer.CreateDrawerDTO;
import fr.baidem.tiroir.service.dto.sock.CreateSockDTO;

@SpringBootApplication
public class TiroirApplication {

	@Autowired
	private DrawerService drawerService;

	@Autowired
	private SockService sockService;
	
	@Autowired
	private SockRepository sockRepository;

	public static void main(String[] args) {
		SpringApplication.run(TiroirApplication.class, args);
	}

	@EventListener(classes = { ApplicationStartedEvent.class })
	public void applicationStarted() {
		System.out.println("Application started");

		List<Drawer> drawers = drawerService.findAll();
		List<Sock> socks = sockService.findAll();
		Drawer topDrawer = null;
		

		System.out.println(drawers.size() + " drawer find");

		if (drawers.size() == 0) {
			CreateDrawerDTO dto = new CreateDrawerDTO("top drawer");
			this.drawerService.create(dto);

			CreateDrawerDTO dto2 = new CreateDrawerDTO("bottom drawer");
			this.drawerService.create(dto2);

			drawers = drawerService.findAll();
			for (Drawer drawer : drawers) {
				if (drawer.getName().equals("top drawer")) {
					System.out.println(drawers.size() + " drawer(s) find," + " top drawer created");
					topDrawer = drawer;
				}
				if (drawer.getName().equals("bottom drawer")) {
					System.out.println(drawers.size() + " drawer(s) find," + " bottom drawer created");
				}
			}

			CreateSockDTO dtoSock1 = new CreateSockDTO("sosocks", "red", 42, Style.SPORT_SHORT, Season.SUMMER);
			this.sockService.create(dtoSock1);

			socks = sockService.findAll();
			for (Sock sock : socks) {
				if (sock.getBrand().equals("sosocks")) {
					System.out.println(socks.size() + " some sock find," + " red sosocks created");
					sock.setDrawer(topDrawer);
					this.sockRepository.save(sock);

				}
			}
		}
	}

}
