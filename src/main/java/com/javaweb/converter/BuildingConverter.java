package com.javaweb.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.dto.BuildingResponseDTO;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.enity.BuildingEntity;
import com.javaweb.repository.enity.DistrictEntity;
import com.javaweb.repository.enity.RentAreaEntity;

@Component 
// Định đây là 1 bean
public class BuildingConverter {
	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private RentAreaRepository rentAreaRepository;
	// CÓ 2 hàm
	// Hàm thứ nhất chuyển từ DTO -> Entity
	// Hàm thứ 2 chuyển từ Entity -> DTO

	// Hàm thứ hai
	public BuildingResponseDTO toBuildingSearchResponseDTO(BuildingEntity buildingEntity) {
		BuildingResponseDTO buildingResponse = new BuildingResponseDTO();

		buildingResponse.setId(buildingEntity.getId());
		buildingResponse.setName(buildingEntity.getName());
		buildingResponse.setNumberOfBasement(buildingEntity.getNumberOfBasement());
		buildingResponse.setRentPrice(buildingEntity.getRentPrice());
		// Chính xác phải là tên quận không phải id của quận, này phải sửa
//		buildingResponse.setAddress(
//				buildingEntity.getStreet() + "," + buildingEntity.getWard() + buildingEntity.getDistrictId());

		DistrictEntity districtEntity = districtRepository.findById(buildingEntity.getDistrictId());
		buildingResponse.setAddress(
				buildingEntity.getStreet() + "," + buildingEntity.getWard() + "," + districtEntity.getName());
		List<RentAreaEntity> rentArea = rentAreaRepository.findById(buildingEntity.getId());
		StringBuilder rentAreaValue = new StringBuilder("");
		for (int i = 0; i < rentArea.size(); i++) {
			rentAreaValue.append(rentArea.get(i).getValue() + "'"); // Nếu không có .getValue thì in ra gì ?
			if (i < rentArea.size() - 1) {
				rentAreaValue.append(",");
			}
		}
		// Thử làm với Java Stream xem
		buildingResponse.setRentArea(rentAreaValue.toString());
		return buildingResponse;
	}
}
