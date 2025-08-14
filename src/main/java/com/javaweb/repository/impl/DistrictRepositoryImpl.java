package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.enity.DistrictEntity;
import com.javaweb.util.ConnectionDriverUtils;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

	@Override
	public DistrictEntity findById(Long id) {
		StringBuilder sql = new StringBuilder("");
		sql.append("SELECT * FROM district d WHERE d.id = " + id);
		DistrictEntity districtEntity = new DistrictEntity();
		try (Connection con = ConnectionDriverUtils.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql.toString())) {
			while (rs.next()) {
				districtEntity.setId(rs.getLong("id"));
				districtEntity.setCode(rs.getString("code"));
				districtEntity.setName(rs.getString("name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return districtEntity;
	}
}
