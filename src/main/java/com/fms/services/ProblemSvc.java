package com.fms.services;

import com.fms.models.Problem;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public interface ProblemSvc extends GenericSvc<Problem> {

    List<Problem> findByMaintenanceId(int id);
}
