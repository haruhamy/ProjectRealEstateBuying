package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.enity.BuildingEntity;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> {
	// Tìm kiếm theo điều kiện truyền vào
	List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}
