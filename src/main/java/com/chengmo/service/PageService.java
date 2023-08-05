package com.chengmo.service;

import com.chengmo.entity.Page;

import java.util.List;

/**
 * Create by chengmo at 2023/08/05
 */
public interface PageService {
    List<Page> findAll(Page page);

    boolean addPage(Page page);

    boolean updatePage(Page page);

    boolean deletePageByIds(Integer[] ids);
}
