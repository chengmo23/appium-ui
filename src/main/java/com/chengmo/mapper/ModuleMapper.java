package com.chengmo.mapper;

import com.chengmo.entity.Module;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create by chengmo at 2023/08/05
 */
@Mapper
public interface ModuleMapper {
    List<Module> findAll(Module module);

    boolean addModule(Module module);

    boolean updateModule(Module module);

    boolean deleteModuleByIds(Integer[] ids);
}
