package com.chengmo.service.impl;

import com.chengmo.entity.Step;
import com.chengmo.mapper.StepMapper;
import com.chengmo.service.StepService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StepServiceImpl implements StepService {

    @Resource
    private StepMapper stepMapper;

    @Override
    public List<Step> findAll(Step step) {
        return stepMapper.findAll(step);
    }

    @Override
    public boolean addStep(Step step) {
        return stepMapper.addStep(step);
    }

    @Override
    public boolean updateStep(Step step) {
        return stepMapper.updateStep(step);
    }

    @Override
    public boolean deleteStepByIds(Integer[] ids) {
        return stepMapper.deleteStepByIds(ids);
    }
}
