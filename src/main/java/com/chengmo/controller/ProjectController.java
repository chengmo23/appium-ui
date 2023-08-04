package com.chengmo.controller;

import com.chengmo.app.Project;
import com.chengmo.service.ProjectService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Create by chengmo at 2023/08/04
 */
@Log4j2
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @PostMapping("/list")
    List<Project> projectList(@RequestBody Project project) {
        log.info(project.getProjectName());
        if (project.getProjectName() == null || project.getProjectName().isEmpty()){
            return projectService.findAll();
        } else {
            log.info("byName");
            return projectService.findByProjectName(project.getProjectName());
        }
    }

    @PostMapping("/add")
    boolean addProject(@RequestBody Project project){
        log.info(project);
        return projectService.addProject(project);
    }

    @PostMapping("/update")
    boolean updateProject(@RequestBody Project project){
        log.info(project);
        return projectService.updateProject(project);
    }

    @PostMapping("/delete")
    boolean deleteProjectById(@RequestBody Integer[] ids){
        log.info(Arrays.toString(ids));
        return projectService.deleteProjectById(ids);
    }
}