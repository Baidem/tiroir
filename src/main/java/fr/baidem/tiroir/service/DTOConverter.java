package fr.baidem.tiroir.service;

import java.util.List;

public interface DTOConverter<ENTITY, DTO> {
	
	DTO convertTo(ENTITY entity);
	
	List<DTO> convertTo(List<ENTITY> drawers);

}
