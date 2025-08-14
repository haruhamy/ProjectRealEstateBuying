package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.enity.RentAreaEntity;
import com.javaweb.util.ConnectionDriverUtils;

@Repository
public class RentAreaImpl implements RentAreaRepository {

	@Override
	public List<RentAreaEntity> findById(Long buildingId) {
		StringBuilder sql = new StringBuilder("");
		sql.append("SELECT * FROM rentarea r WHERE r.buildingId = " + buildingId);
		List<RentAreaEntity> rentAreaEntity = new ArrayList<RentAreaEntity>();
		try (Connection con = ConnectionDriverUtils.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql.toString())) {
			while (rs.next()) {
				RentAreaEntity areaEntity = new RentAreaEntity();
				areaEntity.setId(rs.getLong("id"));
				areaEntity.setValue(rs.getLong("value"));
				areaEntity.setBuildingId(rs.getLong("buildingid"));
				rentAreaEntity.add(areaEntity);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rentAreaEntity;
	}

}
