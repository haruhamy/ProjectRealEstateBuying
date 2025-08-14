package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.converter.BuildingConverter;
import com.javaweb.dto.BuildingResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.enity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private BuildingConverter buildingConverter;

	@Override
	public List<BuildingResponseDTO> findAll(Map<String, Object> params, List<String> typeCode) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(params, typeCode);

		// filter
		List<BuildingResponseDTO> result = new ArrayList<>();
		for (BuildingEntity buildingEntity : buildingEntities) {
			BuildingResponseDTO buildingResponse = buildingConverter.toBuildingSearchResponseDTO(buildingEntity);
			result.add(buildingResponse);
		}
		return result;
	}
}
