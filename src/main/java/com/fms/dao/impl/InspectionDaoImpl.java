package com.fms.dao.impl;

import com.fms.dao.InspectionDao;
import com.fms.entity.InspectionEntity;
import com.fms.models.Inspection;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class InspectionDaoImpl extends HibernateDaoSupport
        implements InspectionDao {
    @Override
    public Integer save(Inspection entity) {
        return (Integer) getHibernateTemplate().save(new InspectionEntity(entity));
    }

    @Override
    public void update(Inspection entity) {
        getHibernateTemplate().update(new InspectionEntity(entity));
    }

    @Override
    public void delete(Inspection entity) {
        if (findById(entity.getId()) != null)
            getHibernateTemplate().delete(new InspectionEntity(entity));
    }

    @Override
    public Inspection findById(int id) {
        List<InspectionEntity> list = getHibernateTemplate().find("from InspectionEntity where id=?", id);
        if (!CollectionUtils.isEmpty(list))
            return list.get(0).toInspection();
        return null;
    }

    @Override
    public List<Inspection> findAll() {
        List<Inspection> inspections;
        List<InspectionEntity> list = getHibernateTemplate().find("from InspectionEntity");
        if (!CollectionUtils.isEmpty(list)) {
            inspections = new ArrayList<Inspection>(list.size());
            for (InspectionEntity inspectionEntity : list)
                inspections.add(inspectionEntity.toInspection());
            return inspections;
        }
        return null;
    }

    @Override
    public List<Inspection> findByUsageId(int id) {
        List<Inspection> inspections;
        List<InspectionEntity> list = getHibernateTemplate().find("from InspectionEntity where usageId=?", id);
        if (!CollectionUtils.isEmpty(list)) {
            inspections = new ArrayList<Inspection>(list.size());
            for (InspectionEntity inspectionEntity : list)
                inspections.add(inspectionEntity.toInspection());
            return inspections;
        }
        return null;
    }
}
