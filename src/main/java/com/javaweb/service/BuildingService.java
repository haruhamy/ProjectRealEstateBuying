package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.BuildingResponseDTO;
import com.javaweb.repository.enity.BuildingEntity;

public interface BuildingService {

	List<BuildingResponseDTO> findAll(Map<String, Object> params, List<String> typeCode);
	
	BuildingEntity createBuilding(BuildingDTO buildingDTO);
}
