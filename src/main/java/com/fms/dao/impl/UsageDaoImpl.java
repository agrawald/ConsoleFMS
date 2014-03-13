package com.fms.dao.impl;

import com.fms.dao.UsageDao;
import com.fms.entity.UsageEntity;
import com.fms.models.Usage;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class UsageDaoImpl extends HibernateDaoSupport
        implements UsageDao {
    @Override
    public Integer save(Usage entity) {
        return (Integer) getHibernateTemplate().save(new UsageEntity(entity));
    }

    @Override
    public void update(Usage entity) {
        getHibernateTemplate().update(new UsageEntity(entity));
    }

    @Override
    public void delete(Usage entity) {
        if (findById(entity.getId()) != null)
            getHibernateTemplate().delete(new UsageEntity(entity));
    }

    @Override
    public Usage findById(int id) {
        List<UsageEntity> list = getHibernateTemplate().find("from UsageEntity where id=?", id);
        if (!CollectionUtils.isEmpty(list))
            return list.get(0).toUsage();
        return null;
    }

    @Override
    public List<Usage> findAll() {
        List<Usage> usages;
        List<UsageEntity> list = getHibernateTemplate().find("from UsageEntity");
        if (!CollectionUtils.isEmpty(list)) {
            usages = new ArrayList<Usage>(list.size());
            for (UsageEntity usageEntity : list)
                usages.add(usageEntity.toUsage());
            return usages;
        }
        return null;
    }

    @Override
    public List<Usage> findByFacilityId(int id) {
        List<Usage> usages;
        List<UsageEntity> list = getHibernateTemplate().find("from UsageEntity where facilityId=?", id);
        if (!CollectionUtils.isEmpty(list)) {
            usages = new ArrayList<Usage>(list.size());
            for (UsageEntity usageEntity : list)
                usages.add(usageEntity.toUsage());
            return usages;
        }
        return null;
    }
}
