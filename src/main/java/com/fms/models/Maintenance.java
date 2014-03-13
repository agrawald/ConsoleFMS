package com.fms.models;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by e7006722 on 6/03/14.
 */
public class Maintenance {
    private int id;
    private Integer facilityId;
    private Integer cost;
    private String startDate;
    private String endDate;

    public Maintenance() {
    }

    public Maintenance(int id) {
        this.id = id;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Maintenance)) return false;

        Maintenance that = (Maintenance) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Maintenance{");
        sb.append("id=").append(id);
        sb.append(", facilityId=").append(facilityId);
        sb.append(", cost=").append(cost);
        sb.append(", startDate='").append(startDate).append('\'');
        sb.append(", endDate='").append(endDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
