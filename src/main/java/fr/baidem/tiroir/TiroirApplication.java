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
		Drawer bottomDrawer = null;

		

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
					bottomDrawer = drawer;
				}
			}

			CreateSockDTO dtoSock1 = new CreateSockDTO("sosocks", "blue", 42, Style.CITY_LONG, Season.SPRING);
			this.sockService.create(dtoSock1);
			
			CreateSockDTO dtoSock2 = new CreateSockDTO("sosocks", "green", 42, Style.CITY_LONG, Season.SPRING);
			this.sockService.create(dtoSock2);
			
			CreateSockDTO dtoSock3 = new CreateSockDTO("sosocks", "yellow", 42, Style.CITY_LONG, Season.SPRING);
			this.sockService.create(dtoSock3);
			
			CreateSockDTO dtoSock4 = new CreateSockDTO("sosocks", "red", 42, Style.SPORT_LONG, Season.WINTER);
			this.sockService.create(dtoSock4);
			
			CreateSockDTO dtoSock5 = new CreateSockDTO("dim", "blue", 42, Style.CITY_SHORT, Season.SUMMER);
			this.sockService.create(dtoSock5);
			
			CreateSockDTO dtoSock6 = new CreateSockDTO("dim", "green", 42, Style.CITY_SHORT, Season.SUMMER);
			this.sockService.create(dtoSock6);
			
			CreateSockDTO dtoSock7 = new CreateSockDTO("dim", "yellow", 42, Style.SPORT_LONG, Season.AUTUMN);
			this.sockService.create(dtoSock7);
			
			CreateSockDTO dtoSock8 = new CreateSockDTO("dim", "red", 42, Style.CITY_SHORT, Season.SUMMER);
			this.sockService.create(dtoSock8);

			socks = sockService.findAll();
			for (Sock sock : socks) {
				if (sock.getBrand().equals("sosocks") && sock.getColor().equals("blue")) {
					sock.setDrawer(topDrawer);
					this.sockRepository.save(sock);
					System.out.println("blue sosocks created in the top drawer");
				}
				
				if (sock.getBrand().equals("sosocks") && sock.getColor().equals("green")) {
					sock.setDrawer(topDrawer);
					this.sockRepository.save(sock);
					System.out.println("green sosocks created in the top drawer");
				}
				
				if (sock.getBrand().equals("sosocks") && sock.getColor().equals("yellow")) {
					sock.setDrawer(topDrawer);
					this.sockRepository.save(sock);
					System.out.println("yellow sosocks created in the top drawer");
				}
				
				if (sock.getBrand().equals("sosocks") && sock.getColor().equals("red")) {
					sock.setDrawer(topDrawer);
					this.sockRepository.save(sock);
					System.out.println("red sosocks created in the top drawer");
				}
				
				if (sock.getBrand().equals("dim") && sock.getColor().equals("blue")) {
					sock.setDrawer(bottomDrawer);
					this.sockRepository.save(sock);
					System.out.println("blue dim created in the bottom drawer");
				}
				
				if (sock.getBrand().equals("dim") && sock.getColor().equals("green")) {
					sock.setDrawer(bottomDrawer);
					this.sockRepository.save(sock);
					System.out.println("green dim created in the bottom drawer");
				}
				
				if (sock.getBrand().equals("dim") && sock.getColor().equals("yellow")) {
					sock.setDrawer(bottomDrawer);
					this.sockRepository.save(sock);
					System.out.println("yellow dim created in the bottom drawer");
				}
				
				if (sock.getBrand().equals("dim") && sock.getColor().equals("red")) {
					sock.setDrawer(bottomDrawer);
					this.sockRepository.save(sock);
					System.out.println("red dim created in the bottom drawer");
				}
			}
		}
	}

}
