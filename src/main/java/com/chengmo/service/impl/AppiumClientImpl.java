package com.chengmo.service.impl;

import com.chengmo.appium.AppiumClient;
import com.chengmo.mapper.AppiumClientMapper;
import com.chengmo.service.AppiumClientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by chengmo at 2023/08/05
 */
@Service
public class AppiumClientImpl implements AppiumClientService {
    @Resource
    AppiumClientMapper appiumClientMapper;

    @Override
    public AppiumClient findByAppiumClientId(int appiumClientId) {
        return appiumClientMapper.findByAppiumClientId(appiumClientId);
    }

    @Override
    public List<AppiumClient> findByPlatform(int platform) {
        return appiumClientMapper.findByPlatform(platform);
    }

    @Override
    public List<AppiumClient> findAll(AppiumClient appiumClient) {
        return appiumClientMapper.findAll(appiumClient);
    }

    @Override
    public boolean addAppiumClient(AppiumClient appiumClient) {
        return appiumClientMapper.addAppiumClient(appiumClient);
    }

    @Override
    public boolean updateAppiumClient(AppiumClient appiumClient) {
        return appiumClientMapper.updateAppiumClient(appiumClient);
    }

    @Override
    public boolean deleteAppiumClientByIds(Integer[] ids) {
        return appiumClientMapper.deleteAppiumClientByIds(ids);
    }
}
