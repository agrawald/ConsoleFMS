package com.fms.entity;

import com.fms.models.Facility;

import java.io.Serializable;

/**
 * Created by e7006722 on 6/03/14.
 */
public class FacilityEntity implements Serializable {
    private int id;
    private int availableCapacity;
    private String details;
    private String name;
    private String inUse;
    private String downTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FacilityEntity)) return false;

        FacilityEntity that = (FacilityEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInUse() {
        return inUse;
    }

    public void setInUse(String inUse) {
        this.inUse = inUse;
    }

    public String getDownTime() {
        return downTime;
    }

    public void setDownTime(String downTime) {
        this.downTime = downTime;
    }

    public FacilityEntity() {
    }

    public FacilityEntity(Facility facility) {
        this.id = facility.getId();
        this.availableCapacity = facility.getAvailableCapacity();
        this.details = facility.getDetails();
        this.name = facility.getName();
        this.inUse = facility.getInUse();
        this.downTime = facility.getDownTime();
    }

    public Facility toFacility() {
        Facility facility = new Facility();
        facility.setId(this.id);
        facility.setDetails(this.details);
        facility.setName(this.name);
        facility.setInUse(this.inUse);
        facility.setAvailableCapacity(this.availableCapacity);
        facility.setDownTime(this.downTime);
        return facility;
    }
}
