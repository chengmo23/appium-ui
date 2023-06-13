package com.chengmo.mapper;

import com.chengmo.pojo.Step;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create by chengmo at 2022/10/22
 */

@Mapper
public interface StepMapper {

    Step findById(int id);

    List<Step> findByCaseId(int caseId);
}
