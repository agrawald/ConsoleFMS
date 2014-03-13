package com.fms.services;

import com.fms.models.Inspection;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public interface InspectionSvc extends GenericSvc<Inspection> {

    List<Inspection> findByUsageId(int id);
}
