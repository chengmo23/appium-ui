package com.chengmo.service.impl;

import com.chengmo.entity.Case;
import com.chengmo.mapper.CaseMapper;
import com.chengmo.service.CaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CaseServiceImpl implements CaseService {

    @Resource
    private CaseMapper caseMapper;

    @Override
    public List<Case> findAll(Case cs) {
        return caseMapper.findAll(cs);
    }

    @Override
    public boolean addCase(Case cs) {
        return caseMapper.addCase(cs);
    }

    @Override
    public boolean updateCase(Case cs) {
        return caseMapper.updateCase(cs);
    }

    @Override
    public boolean deleteCaseByIds(Integer[] ids) {
        return caseMapper.deleteCaseByIds(ids);
    }
}
