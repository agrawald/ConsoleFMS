package com.fms.services.impl;

import com.fms.dao.UsageDao;
import com.fms.models.Usage;
import com.fms.services.UsageSvc;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class UsageSvcImpl implements UsageSvc {
    private UsageDao usageDao;

    @Override
    public Integer save(Usage obj) {
        return usageDao.save(obj);
    }

    @Override
    public void update(Usage obj) {
        usageDao.update(obj);
    }

    @Override
    public void delete(Usage obj) {
        usageDao.delete(obj);
    }

    @Override
    public Usage findById(int id) {
        return usageDao.findById(id);
    }

    @Override
    public List<Usage> findAll() {
        return usageDao.findAll();
    }

    public void setUsageDao(UsageDao usageDao) {
        this.usageDao = usageDao;
    }

    public UsageDao getUsageDao() {
        return usageDao;
    }

    @Override
    public List<Usage> findByFacilityId(int id) {
        return usageDao.findByFacilityId(id);
    }
}
