package com.javaweb.repository.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.enity.BuildingEntity;
import com.javaweb.util.ConnectionDriverUtils;

@Primary
@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	// Cần join field nào, tìm kiếm field đó
	// rentArea (tìm theo diện tích thuê)
	// staffId (Tìm kiếm theo nhân viên phụ trách)
	// Tìm kiếm theo loại tòa nhà
	private void buildJoin(com.javaweb.builder.BuildingSearchBuilder buildingSearchBuilder, StringBuilder join) {
		// Lấy StaffId trước
		// if(staffId != null && !staffId.isEmpty()) {
		// Phần nào lặp đi lặp lại ở nhiều class thì cho vào Utils

		if (buildingSearchBuilder.getStaffId() != null) {
			join.append(" join assignmentbuilding asb ON asb.buildingid = b.id ");
		}
		if (!buildingSearchBuilder.getTypeCode().isEmpty() && buildingSearchBuilder.getTypeCode() != null) {
			join.append(" join buildingrenttype brt ON brt.buildingid = b.id ");
			join.append(" join renttype rt ON rt.id = brt.renttypeid ");
		}
		if (buildingSearchBuilder.getRentAreaFrom() != null || buildingSearchBuilder.getRentAreaTo() != null) {
			join.append(" join rentarea ON rentarea.buildingid = b.id ");
		}
	}

	private void buildCondition(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
		// Java Reflection
		// Build Normal trước
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for (Field item : fields) {
				item.setAccessible(true); // Bật cờ lên
				String key = item.getName();
				if (!key.equals("staffId") && !key.equals("typeCode") && !key.startsWith("rentArea")
						&& !key.startsWith("rentPrice")) {
					Object value = item.get(buildingSearchBuilder);
					if (value != null) {
						if (com.javaweb.util.StringUtils.isNumber(value.toString())) {
							where.append(" AND b." + key + " = " + value.toString());
						} else {
							where.append(" AND b." + key + " LIKE '% " + value.toString() + "%'");
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

//		for (Map.Entry<String, Object> item : params.entrySet()) {
//			String key = item.getKey();
//			if (!key.equals("staffId") && !key.equals("typeCode") && !key.startsWith("rentArea")
//					&& !key.startsWith("rentPrice")) {
//				Object value = item.getValue();
//				if (StringUtils.isNotBlank(value.toString())) {
//					if (StringUtils.isNumber(value.toString())) {
//						where.append(" AND b." + key + " = " + value.toString());
//					} else {
//						where.append(" AND b." + key + " LIKE '% " + value.toString() + "%'");
//					}
//				}
//			}
		// Build Special
		Long staffId = buildingSearchBuilder.getStaffId();
		Long rentAreaFrom = buildingSearchBuilder.getRentAreaFrom();
		Long rentAreaTo = buildingSearchBuilder.getRentAreaTo();

		if (buildingSearchBuilder.getStaffId() != null) {
			where.append(" AND asb.staffId = " + staffId);
		}
		if (buildingSearchBuilder.getRentAreaFrom() != null) {
			where.append(" AND rentarea.value >=  " + rentAreaFrom);
		}
		if (buildingSearchBuilder.getRentAreaTo() != null) {
			where.append(" AND rentarea.value <=  " + rentAreaTo);
		}

		List<String> typeCode = buildingSearchBuilder.getTypeCode();
		if (!typeCode.isEmpty() && typeCode != null) {
			where.append(" AND rt.code IN ("
					+ typeCode.stream().map(i -> "'" + i + "'").collect(Collectors.joining(",")) + ")");
//				for(int i = 0; i < typeCode.size(); i++) {
//					where.append("'" + typeCode.get(i) + "'");
//					if(i < typeCode.size() - 1) {
//						where.append(",");
//					}
//				}
//				where.append(")");

		}
		Long rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
		Long rentPriceTo = buildingSearchBuilder.getRentPriceTo();
		if (rentPriceFrom != null) {
			where.append(" AND b.rentprice >=  " + rentPriceFrom);
		}
		if (rentPriceTo != null) {
			where.append(" AND b.rentprice <=  " + rentPriceTo);
		}
	}

	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b");
		// Xong Join gọi hàm nối với chuỗi sql
		buildJoin(buildingSearchBuilder, sql);

		StringBuilder where = new StringBuilder(" WHERE 1 = 1 ");
		buildCondition(buildingSearchBuilder, where);

		// DÙng groupBy tránh lặp lại nhiều lần ở bảng nhiều
		sql.append(where).append(" GROUP BY b.id ");

		List<BuildingEntity> results = new ArrayList<BuildingEntity>();
		try (Connection con = ConnectionDriverUtils.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql.toString())) {
			while (rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setId(rs.getLong("id"));
				building.setName(rs.getString("name"));
				building.setDistrictId(rs.getLong("districtid"));
				building.setNumberOfBasement(rs.getLong("numberOfBasement"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setRentPrice(rs.getLong("rentprice"));
				results.add(building);
			}

			System.out.print("Connected database successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}
}
