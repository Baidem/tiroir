package fr.baidem.tiroir;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import fr.baidem.tiroir.entity.Chaussette;
import fr.baidem.tiroir.entity.Drawer;
import fr.baidem.tiroir.entity.Season;
import fr.baidem.tiroir.entity.Sock;
import fr.baidem.tiroir.entity.Style;
import fr.baidem.tiroir.entity.Tiroir;
import fr.baidem.tiroir.service.ChaussetteService;
import fr.baidem.tiroir.service.DrawerService;
import fr.baidem.tiroir.service.SockService;
import fr.baidem.tiroir.service.TiroirService;
import fr.baidem.tiroir.service.dto.CreateChaussetteDTO;
import fr.baidem.tiroir.service.dto.CreateDrawerDTO;
import fr.baidem.tiroir.service.dto.CreateSockDTO;
import fr.baidem.tiroir.service.dto.CreateTiroirDTO;

@SpringBootApplication
public class TiroirApplication {

	@Autowired
	private TiroirService tiroirService;
	
	@Autowired
	private ChaussetteService chaussetteService;
	
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
		List<Chaussette> chaussettes = chaussetteService.findAll();

		System.out.println(tiroirs.size() + " Tiroir trouvés");

		if (tiroirs.size() == 0) {
			CreateTiroirDTO dto = new CreateTiroirDTO("tiroir du haut");
			this.tiroirService.create(dto);

			CreateTiroirDTO dto2 = new CreateTiroirDTO("tiroir du bas");
			this.tiroirService.create(dto2);
			
			tiroirs = tiroirService.findAll();
			 for (Tiroir tiroir : tiroirs) {
				if (tiroir.getName().equals("tiroir du haut")) {
					System.out.println(tiroirs.size() + " tiroir(s) trouvé(s)," + " création du tiroir du haut");
				}
				if (tiroir.getName().equals("tiroir du bas")) {
					System.out.println(tiroirs.size() + " tiroir(s) trouvé(s)," + " création du tiroir du bas");
				}
			}
			
			 CreateChaussetteDTO dtoChau1 = new CreateChaussetteDTO("rouge", "été");
				this.chaussetteService.create(dtoChau1);
			
				chaussettes = chaussetteService.findAll();
				 for (Chaussette chaussette : chaussettes) {
					if (chaussette.getColor().equals("rouge")) {
						System.out.println(chaussettes.size() + " chaussette(s) trouvée(s)," + " création de chaussette rouge");
					}
				}
			
			
		}
		
		List<Drawer> drawers = drawerService.findAll();
		List<Sock> socks = sockService.findAll();

		System.out.println(drawers.size() + " drawer find");

		if (drawers.size() == 0) {
			CreateDrawerDTO dto = new CreateDrawerDTO("top drawer");
			this.drawerService.create(dto);
			
			CreateDrawerDTO dto2 = new CreateDrawerDTO("bottom drawer");
			this.drawerService.create(dto2);
						
			drawers = drawerService.findAll();
			 for (Drawer drawer : drawers) {
				if (drawer.getName().equals("top drawer")) {
					System.out.println(tiroirs.size() + " drawer(s) find," + " top drawer created");
				}
				if (drawer.getName().equals("bottom drawer")) {
					System.out.println(tiroirs.size() + " drawer(s) find," + " bottom drawer created");
				}
			}
			
			 CreateSockDTO dtoSock1 = new CreateSockDTO("sosocks", "red", 42, Style.SPORT_SHORT, Season.SUMMER);
				this.sockService.create(dtoSock1);
			
				socks = sockService.findAll();
				 for (Sock sock : socks) {
					if (sock.getBrand().equals("sosocks")) {
						System.out.println(socks.size() + " some sock find," + " red sosocks created");
					}
				}
		
		}

	}

}
