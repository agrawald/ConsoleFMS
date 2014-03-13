package com.fms.dao;

import com.fms.models.Maintenance;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public interface MaintenanceDao extends GenericDao<Maintenance> {
    List<Maintenance> findByFacilityId(int id);
}
