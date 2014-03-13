package com.fms.dao;

import com.fms.models.User;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public interface UserDao extends GenericDao<User> {

    List<User> findByFacilityId(int id);
}
