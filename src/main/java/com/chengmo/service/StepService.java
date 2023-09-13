package com.chengmo.service;

import com.chengmo.entity.Step;

import java.util.List;

public interface StepService {

    List<Step> findAll(Step step);

    boolean addStep(Step step);

    boolean updateStep(Step step);

    boolean deleteStepByIds(Integer[] ids);
}
