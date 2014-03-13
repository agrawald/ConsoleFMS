package com.fms.services;

import com.fms.models.Usage;

import java.util.List;

/**
 * Created by e7006722 on 6/03/14.
 */
public interface UsageSvc extends GenericSvc<Usage> {

    List<Usage> findByFacilityId(int id);
}
