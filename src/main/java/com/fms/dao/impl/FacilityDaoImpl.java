package com.fms.dao.impl;

import com.fms.dao.FacilityDao;
import com.fms.entity.FacilityEntity;
import com.fms.models.Facility;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class FacilityDaoImpl extends HibernateDaoSupport
        implements FacilityDao {
    @Override
    public Integer save(Facility entity) {
        return (Integer) getHibernateTemplate().save(new FacilityEntity(entity));
    }

    @Override
    public void update(Facility entity) {
        getHibernateTemplate().update(new FacilityEntity(entity));
    }

    @Override
    public void delete(Facility entity) {
        if (findById(entity.getId()) != null)
            getHibernateTemplate().delete(new FacilityEntity(entity));
    }

    @Override
    public Facility findById(int id) {
        List<FacilityEntity> list = getHibernateTemplate().find("from FacilityEntity where id=?", id);
        if (!CollectionUtils.isEmpty(list))
            return list.get(0).toFacility();
        return null;
    }

    @Override
    public List<Facility> findAll() {
        List<Facility> facilities;
        List<FacilityEntity> list = getHibernateTemplate().find("from FacilityEntity");
        if (!CollectionUtils.isEmpty(list)) {
            facilities = new ArrayList<Facility>(list.size());
            for (FacilityEntity facilityEntity : list)
                facilities.add(facilityEntity.toFacility());
            return facilities;
        }
        return null;
    }
}
