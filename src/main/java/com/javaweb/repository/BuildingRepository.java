package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import com.javaweb.repository.enity.BuildingEntity;

public interface BuildingRepository {
	// Tìm kiếm theo điều kiện truyền vào
	List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeCode);
}
