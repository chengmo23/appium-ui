package com.chengmo.controller;

import com.chengmo.entity.Project;
import com.chengmo.common.ResultBean;
import com.chengmo.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by chengmo at 2023/08/04
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @PostMapping("/list")
    public ResultBean<List<Project>> projectList(@RequestBody Project project) {
        return ResultBean.success(projectService.findAll(project));
    }

    @PostMapping("/add")
    public ResultBean<Boolean> addProject(@RequestBody Project project){
        if (projectService.addProject(project)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }

    @PostMapping("/update")
    public ResultBean<Boolean> updateProject(@RequestBody Project project){
        if (projectService.updateProject(project)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }

    @PostMapping("/delete")
    public ResultBean<Boolean> deleteProjectById(@RequestBody Integer[] ids){
        if (projectService.deleteProjectByIds(ids)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }
}