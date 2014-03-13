package com.fms.models;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by e7006722 on 11/03/14.
 */
public class User {
    private int id;
    private String name;
    private int facilityId;

    public int getId() {
        return id;
    }

    public User(int id) {
        this.id = id;
    }

    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", facilityId=").append(facilityId);
        sb.append('}');
        return sb.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }
}
