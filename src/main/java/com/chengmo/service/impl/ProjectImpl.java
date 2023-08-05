package com.chengmo.service.impl;

import com.chengmo.entity.Project;
import com.chengmo.mapper.ProjectMapper;
import com.chengmo.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by chengmo at 2023/08/04
 */
@Service
public class ProjectImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public List<Project> findAll(Project project) {
        return projectMapper.findAll(project);
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
    public boolean deleteProjectByIds(Integer[] ids) {
        return projectMapper.deleteProjectByIds(ids);
    }
}
