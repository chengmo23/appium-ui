package com.chengmo.controller;

import com.chengmo.common.ResultBean;
import com.chengmo.entity.Page;
import com.chengmo.service.PageService;
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
@RequestMapping("/page")
public class PageController {
    @Resource
    private PageService pageService;

    @PostMapping("/list")
    public ResultBean<List<Page>> findAll(@RequestBody Page page) {
        return ResultBean.success(pageService.findAll(page));
    }

    @PostMapping("/add")
    public ResultBean<Boolean> addPage(@RequestBody Page page){
        if (pageService.addPage(page)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }

    @PostMapping("/update")
    public ResultBean<Boolean> updatePage(@RequestBody Page page){
        if (pageService.updatePage(page)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }

    @PostMapping("/delete")
    public ResultBean<Boolean> deletePageById(@RequestBody Integer[] ids){
        if (pageService.deletePageByIds(ids)) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }
}
