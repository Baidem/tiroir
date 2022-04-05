package fr.baidem.tiroir.service.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.baidem.tiroir.entity.Chaussette;
import fr.baidem.tiroir.service.ChaussetteService;

@SpringBootTest
class CreateChaussetteDTOTest {
	
	@Autowired
	private ChaussetteService chaussetteService;

	@Test
	void testCreateChaussetteDTO() {
		
		CreateChaussetteDTO dto = new CreateChaussetteDTO("Couleur de test", "Saison de test");
		chaussetteService.create(dto);
		List<Chaussette> chaussettes = chaussetteService.findByColor("Couleur de test");
		boolean colorIsFound = false;
		for (Chaussette chaussette : chaussettes) {
			if (chaussette.getColor().equals("Couleur de test")) {
				colorIsFound = true;
			}
		}
		boolean seasonIsFound = false;
		for (Chaussette chaussette : chaussettes) {
			if (chaussette.getSeason().equals("Saison de test")) {
				seasonIsFound = true;
			}
		}
		assertTrue(colorIsFound && seasonIsFound);
		
	}

}
