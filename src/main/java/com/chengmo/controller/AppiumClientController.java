package com.chengmo.controller;

import com.chengmo.appium.AppiumClient;
import com.chengmo.common.ResultBean;
import com.chengmo.service.AppiumClientService;
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
@RequestMapping("/client")
public class AppiumClientController {
    @Resource
    private AppiumClientService appiumClientService;

    @PostMapping("/list")
    public ResultBean<List<AppiumClient>> findAll(@RequestBody AppiumClient appiumClient) {
        return ResultBean.success(appiumClientService.findAll(appiumClient));
    }

    @PostMapping("/add")
    public ResultBean<Boolean> addAppiumClient(@RequestBody AppiumClient appiumClient){
        if (appiumClientService.addAppiumClient(appiumClient)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }

    @PostMapping("/update")
    public ResultBean<Boolean> updateAppiumClient(@RequestBody AppiumClient appiumClient){
        if (appiumClientService.updateAppiumClient(appiumClient)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }

    @PostMapping("/delete")
    public ResultBean<Boolean> deleteAppiumClientByIds(@RequestBody Integer[] ids){
        if (appiumClientService.deleteAppiumClientByIds(ids)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }
}
