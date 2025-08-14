package com.javaweb.builder;

import java.util.List;

public class BuildingSearchBuilder {
    private String name;
    private Integer floorArea;
    private Long districtId;
    private String ward;
    private String street;
    private Integer numberOfBasement;
    private String direction;
    private String level;
    private Long rentAreaFrom;
    private Long rentAreaTo;
    private Long rentPriceFrom;
    private Long rentPriceTo;
    private String managerName;
    private String managerPhoneNumber;
    private Long staffId;
    private List<String> typeCode;

    // Getters
    public String getName() { return name; }
    public Integer getFloorArea() { return floorArea; }
    public Long getDistrictId() { return districtId; }
    public String getWard() { return ward; }
    public String getStreet() { return street; }
    public Integer getNumberOfBasement() { return numberOfBasement; }
    public String getDirection() { return direction; }
    public String getLevel() { return level; }
    public Long getRentAreaFrom() { return rentAreaFrom; }
    public Long getRentAreaTo() { return rentAreaTo; }
    public Long getRentPriceFrom() { return rentPriceFrom; }
    public Long getRentPriceTo() { return rentPriceTo; }
    public String getManagerName() { return managerName; }
    public String getManagerPhoneNumber() { return managerPhoneNumber; }
    public Long getStaffId() { return staffId; }
    public List<String> getTypeCode() { return typeCode; }

    // Builder Pattern
    public static class Builder {
        private String name;
        private Integer floorArea;
        private Long districtId;
        private String ward;
        private String street;
        private Integer numberOfBasement;
        private String direction;
        private String level;
        private Long rentAreaFrom;
        private Long rentAreaTo;
        private Long rentPriceFrom;
        private Long rentPriceTo;
        private String managerName;
        private String managerPhoneNumber;
        private Long staffId;
        private List<String> typeCode;

        // Setter-style builder methods
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder floorArea(Integer floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public Builder districtId(Long districtId) {
            this.districtId = districtId;
            return this;
        }

        public Builder ward(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder numberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public Builder direction(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder level(String level) {
            this.level = level;
            return this;
        }

        public Builder rentAreaFrom(Long rentAreaFrom) {
            this.rentAreaFrom = rentAreaFrom;
            return this;
        }

        public Builder rentAreaTo(Long rentAreaTo) {
            this.rentAreaTo = rentAreaTo;
            return this;
        }

        public Builder rentPriceFrom(Long rentPriceFrom) {
            this.rentPriceFrom = rentPriceFrom;
            return this;
        }

        public Builder rentPriceTo(Long rentPriceTo) {
            this.rentPriceTo = rentPriceTo;
            return this;
        }

        public Builder managerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public Builder managerPhoneNumber(String managerPhoneNumber) {
            this.managerPhoneNumber = managerPhoneNumber;
            return this;
        }

        public Builder staffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder typeCode(List<String> typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        // build() method tạo đối tượng BuildingSearchBuilder
        public BuildingSearchBuilder build() {
            BuildingSearchBuilder result = new BuildingSearchBuilder();
            result.name = this.name;
            result.floorArea = this.floorArea;
            result.districtId = this.districtId;
            result.ward = this.ward;
            result.street = this.street;
            result.numberOfBasement = this.numberOfBasement;
            result.direction = this.direction;
            result.level = this.level;
            result.rentAreaFrom = this.rentAreaFrom;
            result.rentAreaTo = this.rentAreaTo;
            result.rentPriceFrom = this.rentPriceFrom;
            result.rentPriceTo = this.rentPriceTo;
            result.managerName = this.managerName;
            result.managerPhoneNumber = this.managerPhoneNumber;
            result.staffId = this.staffId;
            result.typeCode = this.typeCode;
            return result;
        }
    }
}

