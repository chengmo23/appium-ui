package com.chengmo.service;

import com.chengmo.appium.AppiumClient;

import java.util.List;

/**
 * Create by chengmo at 2023/08/05
 */
public interface AppiumClientService {
    AppiumClient findByAppiumClientId(int appiumClientId);

    List<AppiumClient> findByPlatform(int platform);

    List<AppiumClient> findAll(AppiumClient appiumClient);

    boolean addAppiumClient(AppiumClient appiumClient);

    boolean updateAppiumClient(AppiumClient appiumClient);

    boolean deleteAppiumClientByIds(Integer[] ids);
}
