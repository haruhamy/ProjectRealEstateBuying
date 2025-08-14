package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.enity.BuildingEntity;
import com.javaweb.util.ConnectionDriverUtils;
import com.javaweb.util.StringUtils;

@Primary
@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	// Cần join field nào, tìm kiếm field đó
	// rentArea (tìm theo diện tích thuê)
	// staffId (Tìm kiếm theo nhân viên phụ trách)
	// Tìm kiếm theo loại tòa nhà
	private void buildJoin(Map<String, Object> params, List<String> typeCode, StringBuilder join) {
		// Lấy StaffId trước
		String staffId = (String) params.get("staffId");
		// if(staffId != null && !staffId.isEmpty()) {
		// Phần nào lặp đi lặp lại ở nhiều class thì cho vào Utils

		if (StringUtils.isNotBlank(staffId)) {
			join.append(" join assignmentbuilding asb ON asb.buildingid = b.id ");
		}
		if (!typeCode.isEmpty() && typeCode != null) {
			join.append(" join buildingrenttype brt ON brt.buildingid = b.id ");
			join.append(" join renttype rt ON rt.id = brt.renttypeid ");
		}
		String rentAreaFrom = (String) params.get("rentAreaFrom");
		String rentAreaTo = (String) params.get("rentAreaTo");
		if (StringUtils.isNotBlank(rentAreaTo) || StringUtils.isNotBlank(rentAreaFrom)) {
			join.append(" join rentarea ON rentarea.buildingid = b.id ");
		}
	}

	private void buildCondition(Map<String, Object> params, List<String> typeCode, StringBuilder where) {
		// Duyệt Map
		//Build Normal trước
		for (Map.Entry<String, Object> item : params.entrySet()) {
			String key = item.getKey();
			if (!key.equals("staffId") && !key.equals("typeCode") && !key.startsWith("rentArea")
					&& !key.startsWith("rentPrice")) {
				Object value = item.getValue();
				if(StringUtils.isNotBlank(value.toString())) {
					if(StringUtils.isNumber(value.toString())) {
						where.append(" AND b." + key + " = " + value.toString());
					}
					else {
						where.append(" AND b." + key + " LIKE '% " + value.toString() + "%'");
					}
				}
			}
			//Build Special
			String staffId = (String)params.get("staffId");
			if(StringUtils.isNotBlank(staffId)) {
				where.append(" AND asb.staffId = " + staffId);
			}
			String rentAreaFrom = (String)params.get("rentAreaFrom");
			String rentAreaTo = (String)params.get("rentAreaTo");
			if(StringUtils.isNotBlank(rentAreaFrom)) {
				where.append(" AND rentarea.value >=  " + rentAreaFrom);
			}
			if(StringUtils.isNotBlank(rentAreaTo)) {
				where.append(" AND rentarea.value <=  " + rentAreaTo);
			}
			if(!typeCode.isEmpty() && typeCode != null) {
				where.append(" AND rt.code IN (" + typeCode.stream().map(i -> "'" + i + "'").collect(Collectors.joining(",")) + ")");
//				for(int i = 0; i < typeCode.size(); i++) {
//					where.append("'" + typeCode.get(i) + "'");
//					if(i < typeCode.size() - 1) {
//						where.append(",");
//					}
//				}
//				where.append(")");
				
			}
			String rentPriceFrom = (String)params.get("rentPriceFrom");
			String rentPriceTo = (String)params.get("rentPriceTo");
			if(StringUtils.isNotBlank(rentPriceFrom)) {
				where.append(" AND b.rentprice >=  " + rentPriceFrom);
			}
			if(StringUtils.isNotBlank(rentPriceTo)) {
				where.append(" AND b.rentprice <=  " + rentPriceTo);
			}
		}
	}

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeCode) {
		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b");
		// Xong Join gọi hàm nối với chuỗi sql
		buildJoin(params, typeCode, sql);

		StringBuilder where = new StringBuilder(" WHERE 1 = 1 ");
		buildCondition(params, typeCode, where);

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
