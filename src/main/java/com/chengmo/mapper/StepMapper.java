package com.chengmo.mapper;

import com.chengmo.entity.Step;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StepMapper {

    List<Step> findAll(Step step);

    boolean addStep(Step step);

    boolean updateStep(Step step);

    boolean deleteStepByIds(Integer[] ids);
}
