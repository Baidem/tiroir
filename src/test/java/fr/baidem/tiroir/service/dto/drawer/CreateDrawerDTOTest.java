package fr.baidem.tiroir.service.dto.drawer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.baidem.tiroir.entity.Drawer;
import fr.baidem.tiroir.service.DrawerService;

@SpringBootTest
class CreateDrawerDTOTest {
	
	@Autowired
	private DrawerService drawerService;

	@Test
	void testCreateDrawerDTO() {
		
		CreateDrawerDTO dto = new CreateDrawerDTO("Drawer test");
		drawerService.create(dto);
		List<Drawer> drawers = drawerService.findByName("Drawer test");
		boolean isFound = false;
		for (Drawer drawer : drawers) {
			if (drawer.getName().equals("Drawer test")) {
				isFound = true;
			}
		}
		assertTrue(isFound);
	}

}
