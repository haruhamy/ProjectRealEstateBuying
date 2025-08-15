package com.javaweb.repository.enity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "district")
public class DistrictEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String code;
	
	@Column(nullable = false)
	private String name;
	public Long getId() {
		return id;
	}
	
	@OneToMany(mappedBy = "districtEntity", fetch = FetchType.LAZY)
	//mappedBy là tên fileds của khóa ngoại, dùng để ánh xạ
	private List<BuildingEntity> buildingEntity;
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BuildingEntity> getBuildingEntity() {
		return buildingEntity;
	}
	public void setBuildingEntity(List<BuildingEntity> buildingEntity) {
		this.buildingEntity = buildingEntity;
	}
	
	
}
