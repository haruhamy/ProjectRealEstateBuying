package com.javaweb.repository.enity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "building")
@Getter
@Setter
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "numberofbasement")
	private Long numberOfBasement;

	@Column(name = "rentprice")
	private Long rentPrice;

	@Column(name = "street")
	private String street;

	@Column(name = "ward")
	private String ward;

	@ManyToOne
	// Có Khóa phụ
	@JoinColumn(name = "districtId")
	private DistrictEntity districtEntity;

	@OneToMany(mappedBy = "buildingEntity")
	private List<RentAreaEntity> rentAreaEntity;

	public DistrictEntity getDistrictEntity() {
		return districtEntity;
	}

	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.districtEntity = districtEntity;
	}

	public List<RentAreaEntity> getRentAreaEntity() {
		return rentAreaEntity;
	}

	public void setRentAreaEntity(List<RentAreaEntity> rentAreaEntity) {
		this.rentAreaEntity = rentAreaEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

}
