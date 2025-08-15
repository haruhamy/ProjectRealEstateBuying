package com.javaweb.converter;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.customexception.ValidateDataBuildingException;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.BuildingResponseDTO;
import com.javaweb.repository.enity.BuildingEntity;
import com.javaweb.repository.enity.DistrictEntity;

@Component
// Định đây là 1 bean
public class BuildingConverter {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ModelMapper modelMapper;
	// CÓ 2 hàm
	// Hàm thứ nhất chuyển từ DTO -> Entity
	// Hàm thứ 2 chuyển từ Entity -> DTO

	// Hàm thứ hai
	public BuildingResponseDTO toBuildingSearchResponseDTO(BuildingEntity buildingEntity) {
		BuildingResponseDTO buildingResponse = modelMapper.map(buildingEntity, BuildingResponseDTO.class);
		// Bên trái là đang cầm data, bên phải là class muốn đổ qua
		// Khác kiểu dữ liệu vẫn modelMapper được nhé, chú ý phỏng vấn

//		buildingResponse.setId(buildingEntity.getId());
//		buildingResponse.setName(buildingEntity.getName());
//		buildingResponse.setNumberOfBasement(buildingEntity.getNumberOfBasement());
//		buildingResponse.setRentPrice(buildingEntity.getRentPrice());
		// Chính xác phải là tên quận không phải id của quận, này phải sửa
//		buildingResponse.setAddress(
//				buildingEntity.getStreet() + "," + buildingEntity.getWard() + buildingEntity.getDistrictId());

		// DistrictEntity districtEntity =
		// districtRepository.findById(buildingEntity.getDistrictId());
		buildingResponse.setAddress(buildingEntity.getStreet() + "," + buildingEntity.getWard() + ","
				+ buildingEntity.getDistrictEntity().getName());
		StringBuilder rentAreaValue = new StringBuilder("");
		rentAreaValue.append(buildingEntity.getRentAreaEntity().stream().map(i -> i.getValue().toString())
				.collect(Collectors.joining(",")));

		// Thử làm với Java Stream xem
		buildingResponse.setRentArea(rentAreaValue.toString());
		return buildingResponse;
	}

	public BuildingEntity toBuildingEntity(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
		DistrictEntity districtEntity = entityManager.find(DistrictEntity.class, buildingDTO.getDistrictId());
		if(districtEntity == null) {
			throw new ValidateDataBuildingException("Name or NumberofBasement is NULL");
		}
		buildingEntity.setDistrictEntity(districtEntity);
		return buildingEntity;
	}
}
