package com.chengmo.service;

import com.chengmo.app.Project;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by chengmo at 2023/08/04
 */
public interface ProjectService {

    List<Project> findByProjectName(String projectName);

    List<Project> findAll();

    boolean addProject(Project project);

    boolean updateProject(Project project);

    boolean deleteProjectById(Integer[] ids);


}