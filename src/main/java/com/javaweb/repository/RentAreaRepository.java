package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.enity.RentAreaEntity;

public interface RentAreaRepository {
	public List<RentAreaEntity> findById(Long buildingId);
}
