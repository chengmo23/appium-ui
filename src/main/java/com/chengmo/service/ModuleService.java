package com.chengmo.service;

import com.chengmo.entity.Module;

import java.util.List;

/**
 * Create by chengmo at 2023/08/05
 */
public interface ModuleService {

    List<Module> findAll(Module module);

    boolean addModule(Module module);

    boolean updateModule(Module module);

    boolean deleteModuleByIds(Integer[] ids);
}
