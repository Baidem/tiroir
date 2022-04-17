package fr.baidem.tiroir.service.converter;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import fr.baidem.tiroir.entity.Drawer;
import fr.baidem.tiroir.service.dto.drawer.DrawerDTO;

@Component
public class DrawerConverter implements DTOConverter<Drawer, DrawerDTO> {
	
	@Override
	public DrawerDTO convertTo(Drawer drawer) {
		DrawerDTO dto = new DrawerDTO();
		
		BeanUtils.copyProperties(drawer,  dto);
		
		return dto;
	}
	
	@Override
	public List<DrawerDTO> convertTo(List<Drawer> drawers) {
		List<DrawerDTO> dtos = new LinkedList<>();
		
		for (Drawer drawer : drawers) {
			dtos.add(this.convertTo(drawer));
		}
		
		return dtos;
	}
	

}
