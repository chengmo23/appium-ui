package com.chengmo.service.impl;

import com.chengmo.entity.Page;
import com.chengmo.mapper.PageMapper;
import com.chengmo.service.PageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by chengmo at 2023/08/05
 */
@Service
public class PageImpl implements PageService {
    @Resource
    private PageMapper pageMapper;
    @Override
    public List<Page> findAll(Page page) {
        return pageMapper.findAll(page);
    }

    @Override
    public boolean addPage(Page page) {
        return pageMapper.addPage(page);
    }

    @Override
    public boolean updatePage(Page page) {
        return pageMapper.updatePage(page);
    }

    @Override
    public boolean deletePageByIds(Integer[] ids) {
        return pageMapper.deletePageByIds(ids);
    }
}
