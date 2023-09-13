package com.chengmo.mapper;

import com.chengmo.entity.Case;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CaseMapper {

    List<Case> findAll(Case cs);

    boolean addCase(Case cs);

    boolean updateCase(Case cs);

    boolean deleteCaseByIds(Integer[] ids);
}
