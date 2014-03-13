package com.fms.services.impl;

import com.fms.dao.InspectionDao;
import com.fms.models.Inspection;
import com.fms.services.InspectionSvc;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class InspectionSvcImpl implements InspectionSvc {
    private InspectionDao inspectionDao;

    @Override
    public Integer save(Inspection obj) {
        return inspectionDao.save(obj);
    }

    @Override
    public void update(Inspection obj) {
        inspectionDao.update(obj);
    }

    @Override
    public void delete(Inspection obj) {
        inspectionDao.delete(obj);
    }

    @Override
    public Inspection findById(int id) {
        return inspectionDao.findById(id);
    }

    @Override
    public List<Inspection> findAll() {
        return inspectionDao.findAll();
    }

    public void setInspectionDao(InspectionDao inspectionDao) {
        this.inspectionDao = inspectionDao;
    }

    public InspectionDao getInspectionDao() {
        return inspectionDao;
    }

    @Override
    public List<Inspection> findByUsageId(int id) {
        return inspectionDao.findByUsageId(id);
    }
}
