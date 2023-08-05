package com.chengmo.controller;

import com.chengmo.entity.Element;
import com.chengmo.common.ResultBean;
import com.chengmo.service.ElementService;
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
@RequestMapping("/element")
public class ElementController {
    @Resource
    private ElementService elementService;

    @PostMapping("/list")
    public ResultBean<List<Element>> findAll(@RequestBody Element element) {
        return ResultBean.success(elementService.findAll(element));
    }

    @PostMapping("/add")
    public ResultBean<Boolean> addElement(@RequestBody Element element){
        if (elementService.addElement(element)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }

    @PostMapping("/update")
    public ResultBean<Boolean> updateElement(@RequestBody Element element){
        if (elementService.updateElement(element)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }

    @PostMapping("/delete")
    public ResultBean<Boolean> deleteElementById(@RequestBody Integer[] ids){
        if (elementService.deleteElementByIds(ids)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }
}
