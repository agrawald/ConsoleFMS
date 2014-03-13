package com.fms.dao;

import com.fms.models.Usage;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public interface UsageDao extends GenericDao<Usage> {

    List<Usage> findByFacilityId(int id);
}
