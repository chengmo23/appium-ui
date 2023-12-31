package com.chengmo.mapper;

import com.chengmo.appium.AppiumClient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Create by chengmo at 2022/10/21
 */

@Mapper
public interface AppiumClientMapper {
    AppiumClient findByAppiumClientId(int appiumClientId);

    List<AppiumClient> findByPlatform(int platform);

    List<AppiumClient> findAll(AppiumClient appiumClient);

    boolean addAppiumClient(AppiumClient appiumClient);

    boolean updateAppiumClient(AppiumClient appiumClient);

    boolean deleteAppiumClientByIds(Integer[] ids);
}
