package com.chengmo.handler;

import com.chengmo.pojo.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.Objects;

/**
 * Create by chengmo at 2022/10/24
 */

public abstract class Handler {

    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void HandleCheckNext(AppiumDriver<MobileElement> appiumDriver, Step step) {
        boolean execResult = operation(appiumDriver, step);
        if (Objects.nonNull(nextHandler) && execResult) {
            nextHandler.HandleCheckNext(appiumDriver, step);
        }
        if (!execResult) {
            HandlerScreenshot.screenshot(appiumDriver, step);
        }
    }

    public abstract Boolean operation(AppiumDriver<MobileElement> appiumDriver, Step step);

}
