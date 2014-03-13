package com.fms.entity;

import com.fms.models.Problem;

/**
 * Created by e7006722 on 6/03/14.
 */
public class ProblemEntity {
    private int id;
    private String details;
    private String foundOn;
    private String isResolved;

    private String resolvedOn;
    private Integer maintenanceId;

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

    public String getFoundOn() {
        return foundOn;
    }

    public void setFoundOn(String foundOn) {
        this.foundOn = foundOn;
    }

    public String getIsResolved() {
        return isResolved;
    }

    public void setIsResolved(String isResolved) {
        this.isResolved = isResolved;
    }

    public String getResolvedOn() {
        return resolvedOn;
    }

    public void setResolvedOn(String resolvedOn) {
        this.resolvedOn = resolvedOn;
    }

    public Integer getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProblemEntity)) return false;

        ProblemEntity that = (ProblemEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public ProblemEntity(Problem problem) {
        this.id = problem.getId();
        this.details = problem.getDetails();
        this.foundOn = problem.getFoundOn();
        this.isResolved = problem.getIsResolved();
        this.resolvedOn = problem.getResolvedOn();
        this.maintenanceId = problem.getMaintenanceId();
    }

    public ProblemEntity() {

    }

    public Problem toProblem() {
        Problem problem = new Problem();
        problem.setId(this.getId());
        problem.setDetails(this.getDetails());
        problem.setFoundOn(this.getFoundOn());
        problem.setIsResolved(this.getIsResolved());
        problem.setMaintenanceId(this.getMaintenanceId());
        problem.setResolvedOn(this.getResolvedOn());
        return problem;
    }

}
