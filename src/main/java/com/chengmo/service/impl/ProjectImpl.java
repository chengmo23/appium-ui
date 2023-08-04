package com.chengmo.service.impl;

import com.chengmo.app.Project;
import com.chengmo.mapper.ProjectMapper;
import com.chengmo.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public List<Project> findByProjectName(String projectName) {
        return projectMapper.findByProjectName(projectName);
    }

    @Override
    public List<Project> findAll() {
        return projectMapper.findAll();
    }

    @Override
    public boolean addProject(Project project) {
        return projectMapper.addProject(project);
    }

    @Override
    public boolean updateProject(Project project) {
        return projectMapper.updateProject(project);
    }

    @Override
    public boolean deleteProjectById(Integer[] ids) {
        return projectMapper.deleteProjectById(ids);
    }
}
