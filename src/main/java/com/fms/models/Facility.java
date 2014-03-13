package com.fms.models;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by e7006722 on 6/03/14.
 */
public class Facility {
    private int id;
    private Integer availableCapacity;
    private String details;
    private String name;
    private String inUse;
    private String downTime;

    public Facility() {
    }

    public Facility(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facility)) return false;

        Facility facility = (Facility) o;

        return id == facility.id;

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

    public Integer getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(Integer availableCapacity) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Facility{");
        sb.append("id=").append(id);
        sb.append(", availableCapacity=").append(availableCapacity);
        sb.append(", details='").append(details).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", inUse='").append(inUse).append('\'');
        sb.append(", downTime='").append(downTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
