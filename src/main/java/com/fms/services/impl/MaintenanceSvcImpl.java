package com.fms.services.impl;

import com.fms.dao.MaintenanceDao;
import com.fms.models.Maintenance;
import com.fms.services.MaintenanceSvc;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class MaintenanceSvcImpl implements MaintenanceSvc {
    private MaintenanceDao maintenanceDao;

    @Override
    public Integer save(Maintenance obj) {
        return maintenanceDao.save(obj);
    }

    @Override
    public void update(Maintenance obj) {
        maintenanceDao.update(obj);
    }

    @Override
    public void delete(Maintenance obj) {
        maintenanceDao.delete(obj);
    }

    @Override
    public Maintenance findById(int id) {
        return maintenanceDao.findById(id);
    }

    @Override
    public List<Maintenance> findByFacilityId(int id) {
        return maintenanceDao.findByFacilityId(id);
    }


    @Override
    public List<Maintenance> findAll() {
        return maintenanceDao.findAll();
    }

    public void setMaintenanceDao(MaintenanceDao maintenanceDao) {
        this.maintenanceDao = maintenanceDao;
    }

    public MaintenanceDao getMaintenanceDao() {
        return maintenanceDao;
    }
}
