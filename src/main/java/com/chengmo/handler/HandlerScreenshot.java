package com.chengmo.handler;

import com.chengmo.pojo.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by chengmo at 2022/11/15
 */

@Log4j2
public class HandlerScreenshot {

    static void screenshot(AppiumDriver<MobileElement> appiumDriver, Step step) {
        File screenshot = appiumDriver.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String imagName = "ScreenShot_" + step.getOperationValue() + "_" + simpleDateFormat.format(new Date()) + ".png";
        String path = "/Users/chengmo/Downloads/" + imagName;
        File file = new File(path);
        try {
            FileUtils.copyFile(screenshot, file);
        } catch (IOException e) {
            log.info("截图失败");
            e.printStackTrace();
        }
        log.info("截图保存至: [{}]", path);
    }
}
