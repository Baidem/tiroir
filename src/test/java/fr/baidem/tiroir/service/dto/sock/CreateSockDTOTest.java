package fr.baidem.tiroir.service.dto.sock;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.baidem.tiroir.entity.Season;
import fr.baidem.tiroir.entity.Sock;
import fr.baidem.tiroir.entity.Style;
import fr.baidem.tiroir.service.SockService;

@SpringBootTest
class CreateSockDTOTest {
	
	@Autowired
	private SockService sockService;

	@Test
	void testCreateSockDTOStringStringIntStyleSeason() {
		CreateSockDTO dto = new CreateSockDTO("test brand", "test color", 42, Style.SPORT_SHORT, Season.SPRING);
		sockService.create(dto);
		List<Sock> socks = sockService.findByBrand("test brand");
		boolean brandIsFound = false;
		boolean colorIsFound = false;

		for (Sock sock : socks) {
			if (sock.getBrand().equals("test brand")) {
				brandIsFound = true;
			}
			if (sock.getColor().equals("test color")) {
				colorIsFound = true;
			}
		}
		
		assertTrue(brandIsFound, "brand is not found");
		assertTrue(colorIsFound, "color is not found");
		
	}

}
