package com.chengmo.service.impl;

import com.chengmo.appium.AppiumClient;
import com.chengmo.appium.AppiumHost;
import com.chengmo.mapper.AppiumClientMapper;
import com.chengmo.service.DriverService;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.options.BaseOptions;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;


/**
 * Create by chengmo at 2022/10/20
 */

@Log4j2
@Service
public class DriverImpl implements DriverService {

    @Resource
    AppiumClientMapper appiumClientMapper;

    @Override
    public AppiumDriver initAppiumDriver(int appiumClientId, AppiumHost appiumHost) throws MalformedURLException {

        AppiumClient clientCapabilities = appiumClientMapper.findByAppiumClientId(appiumClientId);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        for (Map.Entry<String, Object> entry : clientCapabilities.getCapabilitiesMap().entrySet()) {
            if (entry.getValue() != null) {
                capabilities.setCapability(BaseOptions.toW3cName(entry.getKey()), entry.getValue());
            }
        }
        log.info(capabilities);
        log.info(appiumHost);

        IOSDriver iosDriver = new IOSDriver(new URL("http://" + appiumHost.getIp() + ":" + appiumHost.getPort()), capabilities);

        return iosDriver;
    }
}
