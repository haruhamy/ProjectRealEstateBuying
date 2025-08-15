package com.javaweb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.enity.BuildingEntity;

@Repository
public class BuildingRepositoryJPA implements BuildingRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		// JPQL
		String sql = "SELECT b FROM BuildingEntity b WHERE 1=1 AND b.name LIKE '%building%' AND b.districtEntity.code LIKE 'Q1'";
		
		/*
		 * Xử lý khi có List RentAreaEntity
		 String sql = "SELECT b FROM BuildingEntity b JOIN b.rentAreaEntity WHERE 1=1 AND b.name LIKE '%building%' AND b.districtEntity.code LIKE 'Q1'"
		 + "AND b.rentAreaEntity.value >= 400";
		 */
		
		// Giả sử lấy vài fields là sẽ không cho
		// String sql = "SELECT b.name b.numberbasement FROM BuildingEntity b WHERE 1=1 AND b.name LIKE '%building%' AND b.districtEntity.code LIKE 'Q1'";
		Query query = entityManager.createQuery(sql, BuildingEntity.class); // Class mà nó sẽ đổ Data vào

		return query.getResultList();
	}
}
