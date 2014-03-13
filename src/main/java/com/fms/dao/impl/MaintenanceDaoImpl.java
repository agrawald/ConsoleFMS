package com.fms.dao.impl;

import com.fms.dao.MaintenanceDao;
import com.fms.entity.MaintenanceEntity;
import com.fms.models.Maintenance;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class MaintenanceDaoImpl extends HibernateDaoSupport
        implements MaintenanceDao {
    @Override
    public Integer save(Maintenance entity) {
        return (Integer) getHibernateTemplate().save(new MaintenanceEntity(entity));
    }

    @Override
    public void update(Maintenance entity) {
        getHibernateTemplate().update(new MaintenanceEntity(entity));
    }

    @Override
    public void delete(Maintenance entity) {
        if (findById(entity.getId()) != null)
            getHibernateTemplate().delete(new MaintenanceEntity(entity));
    }

    @Override
    public Maintenance findById(int id) {
        List<MaintenanceEntity> list = getHibernateTemplate().find("from MaintenanceEntity where id=?", id);
        if (!CollectionUtils.isEmpty(list))
            return list.get(0).toMaintenance();
        return null;
    }

    @Override
    public List<Maintenance> findAll() {
        List<Maintenance> maintenances;
        List<MaintenanceEntity> list = getHibernateTemplate().find("from MaintenanceEntity");
        if (!CollectionUtils.isEmpty(list)) {
            maintenances = new ArrayList<Maintenance>(list.size());
            for (MaintenanceEntity maintenanceEntity : list)
                maintenances.add(maintenanceEntity.toMaintenance());
            return maintenances;
        }
        return null;
    }

    @Override
    public List<Maintenance> findByFacilityId(int id) {
        List<Maintenance> maintenances;
        List<MaintenanceEntity> list = getHibernateTemplate().find("from MaintenanceEntity where facilityId=?", id);
        if (!CollectionUtils.isEmpty(list)) {
            maintenances = new ArrayList<Maintenance>(list.size());
            for (MaintenanceEntity maintenanceEntity : list)
                maintenances.add(maintenanceEntity.toMaintenance());
            return maintenances;
        }
        return null;
    }
}
