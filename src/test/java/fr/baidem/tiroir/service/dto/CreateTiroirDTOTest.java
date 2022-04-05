package fr.baidem.tiroir.service.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.baidem.tiroir.entity.Tiroir;
import fr.baidem.tiroir.service.TiroirService;

@SpringBootTest
class CreateTiroirDTOTest {

	@Autowired
	private TiroirService tiroirService;

	@Test
	void testCreateTiroirDTO() {

		CreateTiroirDTO dto = new CreateTiroirDTO("Tiroir de test");
		tiroirService.create(dto);
		List<Tiroir> tiroirs = tiroirService.findByName("Tiroir de test");
		boolean isFound = false;
		for (Tiroir tiroir : tiroirs) {
			if (tiroir.getName().equals("Tiroir de test")) {
				isFound = true;
			}

		}
		assertTrue(isFound);

	}

}
