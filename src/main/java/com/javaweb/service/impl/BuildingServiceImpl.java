package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.dto.BuildingResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.enity.BuildingEntity;
import com.javaweb.repository.enity.DistrictEntity;
import com.javaweb.repository.enity.RentAreaEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private RentAreaRepository rentAreaRepository;

	@Override
	public List<BuildingResponseDTO> findAll(Map<String, Object> params, List<String> typeCode) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(params, typeCode);

		// filter
		List<BuildingResponseDTO> result = new ArrayList<>();
		for (BuildingEntity buildingEntity : buildingEntities) {
			BuildingResponseDTO buildingResponse = new BuildingResponseDTO();

			buildingResponse.setId(buildingEntity.getId());
			buildingResponse.setName(buildingEntity.getName());
			buildingResponse.setNumberOfBasement(buildingEntity.getNumberOfBasement());
			buildingResponse.setRentPrice(buildingEntity.getRentPrice());
			// Chính xác phải là tên quận không phải id của quận, này phải sửa
//			buildingResponse.setAddress(
//					buildingEntity.getStreet() + "," + buildingEntity.getWard() + buildingEntity.getDistrictId());

			DistrictEntity districtEntity = districtRepository.findById(buildingEntity.getDistrictId());
			buildingResponse.setAddress(
					buildingEntity.getStreet() + "," + buildingEntity.getWard() + "," + districtEntity.getName());
			List<RentAreaEntity> rentArea = rentAreaRepository.findById(buildingEntity.getId());
			StringBuilder rentAreaValue = new StringBuilder("");
			for (int i = 0; i < rentArea.size(); i++) {
				rentAreaValue.append(rentArea.get(i).getValue() + "'"); //Nếu không có .getValue thì in ra gì ?
				if (i < rentArea.size() - 1) {
					rentAreaValue.append(",");
				}
			}
			// Thử làm với Java Stream xem
			buildingResponse.setRentArea(rentAreaValue.toString());
			result.add(buildingResponse);
		}
		return result;
	}
}
