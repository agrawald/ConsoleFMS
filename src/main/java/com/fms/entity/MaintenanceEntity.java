package com.fms.entity;

import com.fms.models.Maintenance;

/**
 * Created by e7006722 on 6/03/14.
 */
public class MaintenanceEntity {
    private int id;
    private int facilityId;
    private int cost;
    private String startDate;
    private String endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public MaintenanceEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaintenanceEntity)) return false;

        MaintenanceEntity that = (MaintenanceEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public MaintenanceEntity(Maintenance maintenance) {
        this.id = maintenance.getId();
        this.facilityId = maintenance.getFacilityId();
        this.cost = maintenance.getCost();
        this.startDate = maintenance.getStartDate();
        this.endDate = maintenance.getEndDate();
    }

    public Maintenance toMaintenance() {
        Maintenance maintenance = new Maintenance();
        maintenance.setId(this.getId());
        maintenance.setCost(this.getCost());
        maintenance.setEndDate(this.getEndDate());
        maintenance.setFacilityId(this.getFacilityId());
        maintenance.setStartDate(this.getStartDate());
        return maintenance;
    }
}
