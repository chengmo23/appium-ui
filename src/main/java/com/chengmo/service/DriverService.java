package com.chengmo.service;

import com.chengmo.appium.AppiumHost;
import io.appium.java_client.AppiumDriver;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;

/**
 * Create by chengmo at 2022/10/21
 */

public interface DriverService {

    AppiumDriver initAppiumDriver(int appiumClientId, AppiumHost appiumHost) throws MalformedURLException;


}
