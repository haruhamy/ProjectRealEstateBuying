package com.javaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customexception.ValidateDataBuildingException;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.BuildingResponseDTO;
import com.javaweb.repository.enity.BuildingEntity;
import com.javaweb.service.BuildingService;

@RestController
@RequestMapping("/api/buildings")
@PropertySource("classpath:application.properties")
public class BuildingAPI {

	@Autowired
	private BuildingService buildingService;
	
	@Value("${devon}")
	private String devon;

	@GetMapping
	public Object getBuilding(@RequestParam Map<String, Object> params,
			@RequestParam(name = "typeCode", required = false) List<String> typeCode) {
		List<BuildingResponseDTO> results = buildingService.findAll(params, typeCode);
		return results;

//			@RequestParam Map<String, Object> params,) {
//				try {
//					System.out.print(4/0);
//				}catch (Exception e) {
//					e.printStackTrace();
//					// TODO: handle exception
//				}
//		try {
//			System.out.print(4 / 0);
//		} catch (Exception e) {
//			ErrorDetailReponse errorDetailReponse = new ErrorDetailReponse();
//			errorDetailReponse.setError(e.getMessage());
//			errorDetailReponse.setDetail(Arrays.asList("So nguyen khong chia duoc cho 0"));
//			e.printStackTrace();
//			return errorDetailReponse;
//		}
//		System.out.print(4 / 0);
//		BuildingDTO building1 = new BuildingDTO();
//		building1.setName("MD Building");
//		building1.setNumberOfBasement(3L);
//		building1.setRentPrice(1222L);
//		building1.setTypeCode(Arrays.asList("tang-tret", "nguyen-can"));

//		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b WHERE 1=1");
//		if(nameBuilding != null && !nameBuilding.equals("")) {
//			sql.append(" AND b.name LIKE '%" + nameBuilding + "%'");
//		}
//		if(numberOfBasement != null) {
//			sql.append(" AND b.numberOfBasement = " + numberOfBasement);
//		}
//		List<BuildingDTO> results = new ArrayList<BuildingDTO>();
//		try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
//				Statement st = con.createStatement();
//				ResultSet rs = st.executeQuery(sql.toString())) {
//			while (rs.next()) {
//				BuildingDTO building = new BuildingDTO();
//				building.setName(rs.getString("name"));
//				building.setNumberOfBasement(rs.getLong("numberOfBasement"));
//				building.setRentPrice(rs.getLong("rentprice"));
//				results.add(building);
//			}
//
//			System.out.print("Connected database successfully");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return results;
//		List<BuildingResponseDTO> result

	}

//	public static void validateDataBuilding(BuildingDTO buildingDTO) throws ValidateDataBuildingException{
//		if(buildingDTO.getName() == null || buildingDTO.getName().isEmpty() || buildingDTO.getNumberOfBasement() == null) {
//			throw new ValidateDataBuildingException("Name or NumberofBasement is NULL");
//		}
//	}

	public static void validateDataBuilding(BuildingDTO buildingDTO) {
		if (buildingDTO.getName() == null || buildingDTO.getName().isEmpty()
				|| buildingDTO.getNumberOfBasement() == null) {
			throw new ValidateDataBuildingException("Name or NumberofBasement is NULL");
		}
	}

//	@PostMapping(value = "api/buildings")
//	public void createBuilding(@RequestBody Map<String, Object> building){
//		System.out.print("OK");
//
//	}

	@PostMapping
	public Object createBuilding(@RequestBody BuildingDTO buildingDTO) {
//		try {
//			validateDataBuilding(buildingDTO);
//		}catch(Exception e){
//			ErrorDetailReponse errorDetailReponse = new ErrorDetailReponse();
//			errorDetailReponse.setError(e.getMessage());
//			return errorDetailReponse;
//		}
		validateDataBuilding(buildingDTO);
		BuildingEntity buildingEntity = buildingService.createBuilding(buildingDTO);
		
		return buildingEntity;

	}

	@DeleteMapping("/{id}/{name}")
	public void deleteBuilding(@PathVariable Long id, @PathVariable String name) {
		System.out.print("Delete" + id);
	}
}
