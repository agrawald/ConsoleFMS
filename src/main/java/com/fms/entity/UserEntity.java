package com.fms.entity;

import com.fms.models.User;

/**
 * Created by e7006722 on 12/03/14.
 */
public class UserEntity {
    private Integer id;
    private String name;
    private Integer facilityId;

    public UserEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (facilityId != null ? !facilityId.equals(that.facilityId) : that.facilityId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (facilityId != null ? facilityId.hashCode() : 0);
        return result;
    }

    public UserEntity(User user) {
        this.id = user.getId();
        this.facilityId = user.getFacilityId();
        this.name = user.getName();
    }

    public User toUser() {
        User user = new User();
        user.setId(this.getId());
        user.setFacilityId(this.getFacilityId());
        user.setName(this.getName());
        return user;
    }
}
