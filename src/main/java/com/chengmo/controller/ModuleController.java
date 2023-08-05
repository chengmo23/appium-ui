package com.chengmo.controller;

import com.chengmo.entity.Module;
import com.chengmo.service.ModuleService;
import com.chengmo.common.ResultBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by chengmo at 2023/08/05
 */
@RestController
@RequestMapping("/module")
public class ModuleController {
    @Resource
    private ModuleService moduleService;

    @PostMapping("/list")
    public ResultBean<List<Module>> findAll(@RequestBody Module module) {
        return ResultBean.success(moduleService.findAll(module));
    }

    @PostMapping("/add")
    public ResultBean<Boolean> addModule(@RequestBody Module module){
        if (moduleService.addModule(module)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }

    @PostMapping("/update")
    public ResultBean<Boolean> updateModule(@RequestBody Module module){
        if (moduleService.updateModule(module)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }

    @PostMapping("/delete")
    public ResultBean<Boolean> deleteModuleById(@RequestBody Integer[] ids){
        if (moduleService.deleteModuleByIds(ids)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }
}
