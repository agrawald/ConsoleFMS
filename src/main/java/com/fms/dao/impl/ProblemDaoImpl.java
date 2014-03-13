package com.fms.dao.impl;

import com.fms.dao.ProblemDao;
import com.fms.entity.ProblemEntity;
import com.fms.models.Problem;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class ProblemDaoImpl extends HibernateDaoSupport
        implements ProblemDao {
    @Override
    public Integer save(Problem entity) {
        return (Integer) getHibernateTemplate().save(new ProblemEntity(entity));
    }

    @Override
    public void update(Problem entity) {
        getHibernateTemplate().update(new ProblemEntity(entity));
    }

    @Override
    public void delete(Problem entity) {
        if (findById(entity.getId()) != null)
            getHibernateTemplate().delete(new ProblemEntity(entity));
    }

    @Override
    public Problem findById(int id) {
        List<ProblemEntity> list = getHibernateTemplate().find("from ProblemEntity where id=?", id);
        if (!CollectionUtils.isEmpty(list))
            return list.get(0).toProblem();
        return null;
    }

    @Override
    public List<Problem> findAll() {
        List<Problem> problems;
        List<ProblemEntity> list = getHibernateTemplate().find("from ProblemEntity");
        if (!CollectionUtils.isEmpty(list)) {
            problems = new ArrayList<Problem>(list.size());
            for (ProblemEntity problemEntity : list)
                problems.add(problemEntity.toProblem());
            return problems;
        }
        return null;
    }

    @Override
    public List<Problem> findByMaintenanceId(int id) {
        List<Problem> problems;
        List<ProblemEntity> list = getHibernateTemplate().find("from ProblemEntity where maintenanceId=?", id);
        if (!CollectionUtils.isEmpty(list)) {
            problems = new ArrayList<Problem>(list.size());
            for (ProblemEntity problemEntity : list)
                problems.add(problemEntity.toProblem());
            return problems;
        }
        return null;
    }
}
