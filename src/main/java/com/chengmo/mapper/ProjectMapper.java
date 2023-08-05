package com.chengmo.mapper;

import com.chengmo.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create by chengmo at 2023/08/04
 */

@Mapper
public interface ProjectMapper {
    List<Project> findAll(Project project);

    boolean addProject(Project project);

    boolean updateProject(Project project);

    boolean deleteProjectByIds(Integer[] ids);

}