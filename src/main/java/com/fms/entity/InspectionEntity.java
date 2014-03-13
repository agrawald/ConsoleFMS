package com.fms.entity;

import com.fms.models.Inspection;

/**
 * Created by e7006722 on 6/03/14.
 */
public class InspectionEntity {
    private int id;
    private String details;
    private int usageId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getUsageId() {
        return usageId;
    }

    public void setUsageId(int usageId) {
        this.usageId = usageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InspectionEntity)) return false;

        InspectionEntity that = (InspectionEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public InspectionEntity(Inspection inspection) {
        this.id = inspection.getId();
        this.details = inspection.getDetails();
        this.usageId = inspection.getUsageId();
    }

    public InspectionEntity() {
    }

    public Inspection toInspection() {
        Inspection inspection = new Inspection();
        inspection.setId(this.id);
        inspection.setDetails(this.getDetails());
        inspection.setUsageId(this.getUsageId());
        return inspection;
    }
}
