package com.fms.services.impl;

import com.fms.dao.ProblemDao;
import com.fms.models.Problem;
import com.fms.services.ProblemSvc;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class ProblemSvcImpl implements ProblemSvc {
    private ProblemDao problemDao;

    @Override
    public Integer save(Problem obj) {
        return problemDao.save(obj);
    }

    @Override
    public void update(Problem obj) {
        problemDao.update(obj);
    }

    @Override
    public void delete(Problem obj) {
        problemDao.delete(obj);
    }

    @Override
    public Problem findById(int id) {
        return problemDao.findById(id);
    }

    @Override
    public List<Problem> findAll() {
        return problemDao.findAll();
    }

    public void setProblemDao(ProblemDao problemDao) {
        this.problemDao = problemDao;
    }

    public ProblemDao getProblemDao() {
        return problemDao;
    }

    @Override
    public List<Problem> findByMaintenanceId(int id) {
        return problemDao.findByMaintenanceId(id);
    }
}
