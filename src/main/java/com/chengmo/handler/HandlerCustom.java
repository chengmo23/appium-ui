package com.chengmo.handler;

import com.chengmo.pojo.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * Create by chengmo at 2022/10/24
 */

public class HandlerCustom extends Handler{

    @Override
    public Boolean operation(AppiumDriver<MobileElement> appiumDriver, Step step) {
        if (!step.getOperationType().equals(3)) {
            return true;
        }

        boolean result = true;

        switch (step.getOperation()) {
            case "isLogin":
                result = isLogin(appiumDriver);
                break;

            case "login":
                if (!isLogin(appiumDriver)) {
                    login(appiumDriver);
                }
                break;

            case "logout":
                if (isLogin(appiumDriver)) {
                    logout(appiumDriver);
                }
                break;
        }

        return result;
    }


    public boolean isLogin(AppiumDriver<MobileElement> appiumDriver) {
        return true;
    }

    public void login(AppiumDriver<MobileElement> appiumDriver) {

    }

    public void logout(AppiumDriver<MobileElement> appiumDriver) {

    }
}
