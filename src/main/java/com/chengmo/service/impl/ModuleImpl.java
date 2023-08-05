package com.chengmo.service.impl;

import com.chengmo.entity.Module;
import com.chengmo.mapper.ModuleMapper;
import com.chengmo.service.ModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by chengmo at 2023/08/05
 */
@Service
public class ModuleImpl implements ModuleService {
    @Resource
    private ModuleMapper moduleMapper;
    @Override
    public List<Module> findAll(Module module) {
        return moduleMapper.findAll(module);
    }

    @Override
    public boolean addModule(Module module) {
        return moduleMapper.addModule(module);
    }

    @Override
    public boolean updateModule(Module module) {
        return moduleMapper.updateModule(module);
    }

    @Override
    public boolean deleteModuleByIds(Integer[] ids) {
        return moduleMapper.deleteModuleByIds(ids);
    }
}
