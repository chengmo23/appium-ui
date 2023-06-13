package com.chengmo.service.impl;

import com.chengmo.appium.AppiumClient;
import com.chengmo.appium.AppiumHost;
import com.chengmo.mapper.AppiumClientMapper;
import com.chengmo.service.DriverService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Create by chengmo at 2022/10/20
 */

@Log4j2
@Service
public class DriverImpl implements DriverService {

    @Resource
    AppiumClientMapper appiumClientMapper;

    @Override
    public IOSDriver<MobileElement> initIOSDriver(int id, AppiumHost appiumHost) throws MalformedURLException {

        AppiumClient clientCapabilities = appiumClientMapper.findById(id);
        log.info(clientCapabilities);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        for (Map.Entry<String, Object> entry : clientCapabilities.getCapabilitiesMap().entrySet()) {
            if (entry.getValue() != null) {
                capabilities.setCapability(entry.getKey(), entry.getValue());
            }
        }

        log.info(capabilities);

        IOSDriver<MobileElement> IOSDriver = new IOSDriver<>(new URL("http://" + appiumHost.getIp() + ":" + appiumHost.getPort() + "/wd/hub"), capabilities);
        IOSDriver.manage().timeouts().implicitlyWait(clientCapabilities.getImplicitlyWait(), TimeUnit.SECONDS);
        log.info("SessionId: {}", IOSDriver.getSessionId());

        return IOSDriver;
    }

    @Override
    public AndroidDriver<MobileElement> initAndroidDriver(int id, AppiumHost appiumHost) throws MalformedURLException {

        AppiumClient clientCapabilities = appiumClientMapper.findById(id);
        log.info(clientCapabilities);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        for (Map.Entry<String, Object> entry : clientCapabilities.getCapabilitiesMap().entrySet()) {
            if (entry.getValue() != null) {
                capabilities.setCapability(entry.getKey(), entry.getValue());
            }
        }

        log.info(capabilities);

        AndroidDriver<MobileElement> androidDriver = new AndroidDriver<>(new URL("http://" + appiumHost.getIp() + ":" + appiumHost.getPort() + "/wd/hub"), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(clientCapabilities.getImplicitlyWait(), TimeUnit.SECONDS);
        log.info("SessionId: {}", androidDriver.getSessionId());

        return androidDriver;
    }


}
