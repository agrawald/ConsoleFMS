package com.fms.services;

import com.fms.models.User;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public interface UserSvc extends GenericSvc<User> {

    List<User> findByFacilityId(int id);
}
