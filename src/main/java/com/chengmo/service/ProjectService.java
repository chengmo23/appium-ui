package com.chengmo.service;

import com.chengmo.entity.Project;

import java.util.List;

/**
 * Create by chengmo at 2023/08/04
 */
public interface ProjectService {
    List<Project> findAll(Project project);

    boolean addProject(Project project);

    boolean updateProject(Project project);

    boolean deleteProjectByIds(Integer[] ids);

}