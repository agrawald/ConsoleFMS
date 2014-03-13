package com.fms.dao.impl;

import com.fms.dao.UserDao;
import com.fms.entity.UserEntity;
import com.fms.models.User;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public class UserDaoImpl extends HibernateDaoSupport
        implements UserDao {
    @Override
    public Integer save(User entity) {
        return (Integer) getHibernateTemplate().save(new UserEntity(entity));
    }

    @Override
    public void update(User entity) {
        getHibernateTemplate().update(new UserEntity(entity));
    }

    @Override
    public void delete(User entity) {
        if (findById(entity.getId()) != null)
            getHibernateTemplate().delete(new UserEntity(entity));
    }

    @Override
    public User findById(int id) {
        List<UserEntity> list = getHibernateTemplate().find("from UserEntity where id=?", id);
        if (!CollectionUtils.isEmpty(list))
            return list.get(0).toUser();
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users;
        List<UserEntity> list = getHibernateTemplate().find("from UserEntity");
        if (!CollectionUtils.isEmpty(list)) {
            users = new ArrayList<User>(list.size());
            for (UserEntity userEntity : list)
                users.add(userEntity.toUser());
            return users;
        }
        return null;
    }

    @Override
    public List<User> findByFacilityId(int id) {
        List<User> users;
        List<UserEntity> list = getHibernateTemplate().find("from UserEntity where facilityId=?", id);
        if (!CollectionUtils.isEmpty(list)) {
            users = new ArrayList<User>(list.size());
            for (UserEntity userEntity : list)
                users.add(userEntity.toUser());
            return users;
        }
        return null;
    }
}
