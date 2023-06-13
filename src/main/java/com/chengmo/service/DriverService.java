package com.chengmo.service;

import com.chengmo.appium.AppiumHost;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;

/**
 * Create by chengmo at 2022/10/21
 */

public interface DriverService {

    IOSDriver<MobileElement> initIOSDriver(int id, AppiumHost appiumHost) throws MalformedURLException;

    AndroidDriver<MobileElement> initAndroidDriver(int id, AppiumHost appiumHost) throws MalformedURLException;

}
