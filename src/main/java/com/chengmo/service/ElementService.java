package com.chengmo.service;

import com.chengmo.entity.Element;

import java.util.List;

/**
 * Create by chengmo at 2023/08/05
 */
public interface ElementService {
    List<Element> findAll(Element element);

    boolean addElement(Element element);

    boolean updateElement(Element element);

    boolean deleteElementByIds(Integer[] ids);
}
