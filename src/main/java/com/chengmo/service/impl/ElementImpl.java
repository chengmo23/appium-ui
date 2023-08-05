package com.chengmo.service.impl;

import com.chengmo.entity.Element;
import com.chengmo.mapper.ElementMapper;
import com.chengmo.service.ElementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by chengmo at 2023/08/05
 */
@Service
public class ElementImpl implements ElementService {
    @Resource
    private ElementMapper elementMapper;

    @Override
    public List<Element> findAll(Element element) {
        return elementMapper.findAll(element);
    }

    @Override
    public boolean addElement(Element element) {
        return elementMapper.addElement(element);
    }

    @Override
    public boolean updateElement(Element element) {
        return elementMapper.updateElement(element);
    }

    @Override
    public boolean deleteElementByIds(Integer[] ids) {
        return elementMapper.deleteElementByIds(ids);
    }
}
