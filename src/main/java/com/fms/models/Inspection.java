package com.fms.models;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by e7006722 on 6/03/14.
 */
public class Inspection {
    private int id;
    private String details;
    private Integer usageId;

    public Inspection() {
    }

    public Inspection(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inspection)) return false;

        Inspection that = (Inspection) o;

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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getUsageId() {
        return usageId;
    }

    public void setUsageId(Integer usageId) {
        this.usageId = usageId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Inspection{");
        sb.append("id=").append(id);
        sb.append(", details='").append(details).append('\'');
        sb.append(", usageId=").append(usageId);
        sb.append('}');
        return sb.toString();
    }
}
