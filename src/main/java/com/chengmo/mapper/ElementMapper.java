package com.chengmo.mapper;

import com.chengmo.entity.Element;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create by chengmo at 2023/08/05
 */
@Mapper
public interface ElementMapper {
    List<Element> findAll(Element element);

    boolean addElement(Element element);

    boolean updateElement(Element element);

    boolean deleteElementByIds(Integer[] ids);
}
