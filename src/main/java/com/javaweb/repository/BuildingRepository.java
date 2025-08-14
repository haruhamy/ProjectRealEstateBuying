package com.javaweb.repository;

import java.util.List;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.enity.BuildingEntity;

public interface BuildingRepository {
	// Tìm kiếm theo điều kiện truyền vào
	List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}
