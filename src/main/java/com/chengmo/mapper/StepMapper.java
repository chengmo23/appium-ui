package com.chengmo.mapper;

import com.chengmo.app.Element;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create by chengmo at 2022/10/22
 */

@Mapper
public interface StepMapper {

    Element findById(int id);

    List<Element> findByCaseId(int caseId);
}
