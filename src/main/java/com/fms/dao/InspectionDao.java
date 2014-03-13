package com.fms.dao;

import com.fms.models.Inspection;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public interface InspectionDao extends GenericDao<Inspection> {

    List<Inspection> findByUsageId(int id);
}
