package com.chengmo.service;

import com.chengmo.entity.Case;
import com.chengmo.entity.Case;

import java.util.List;

public interface CaseService {
    List<Case> findAll(Case cs);

    boolean addCase(Case cs);

    boolean updateCase(Case cs);

    boolean deleteCaseByIds(Integer[] ids);
}
