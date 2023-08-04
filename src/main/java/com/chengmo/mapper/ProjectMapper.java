package com.chengmo.mapper;

import com.chengmo.app.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create by chengmo at 2023/08/04
 */

@Mapper
public interface ProjectMapper {

    Project findByProjectName(String projectName);

    List<Project> findAll();

    boolean addProject(Project project);

    boolean updateProject(Project project);

    boolean deleteProjectById(Integer[] ids);

}