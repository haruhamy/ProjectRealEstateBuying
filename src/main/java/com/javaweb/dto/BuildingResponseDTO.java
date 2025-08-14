package com.javaweb.dto;

public class BuildingResponseDTO {
	private Long id;
	private String name;
	private Long numberOfBasement;
	private Long rentPrice;
	private String address;
	private String rentArea;

	public String getRentArea() {
		return rentArea;
	}

	public void setRentArea(String rentArea) {
		this.rentArea = rentArea;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}
}
