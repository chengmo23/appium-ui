package com.chengmo.mapper;

import com.chengmo.entity.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create by chengmo at 2023/08/05
 */
@Mapper
public interface PageMapper {
    List<Page> findAll(Page page);

    boolean addPage(Page page);

    boolean updatePage(Page page);

    boolean deletePageByIds(Integer[] ids);
}
