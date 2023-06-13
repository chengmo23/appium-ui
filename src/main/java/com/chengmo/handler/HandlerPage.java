package com.chengmo.handler;

import com.chengmo.pojo.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Create by chengmo at 2022/10/24
 */
@Log4j2
@Component
public class HandlerPage extends Handler {

    @Override
    public Boolean operation(AppiumDriver<MobileElement> appiumDriver, Step step) {

        if (!step.getOperationType().equals(2)) {
            return true;
        }

        boolean result = true;

        int width = appiumDriver.manage().window().getSize().width;
        int height = appiumDriver.manage().window().getSize().height;
        HashMap<String, Object> swipeObject = new HashMap<>();

        switch (step.getOperation()) {
            case "screenshot":
                File screenshot = appiumDriver.getScreenshotAs(OutputType.FILE);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String imagName = "ScreenShot_" + step.getOperationValue() + "_" + simpleDateFormat.format(new Date()) + ".png";
                String path = "/Users/chengmo/Downloads/" + imagName;
                File file = new File(path);
                try {
                    FileUtils.copyFile(screenshot, file);
                } catch (IOException e) {
                    result = false;
                    log.info("截图失败");
                    e.printStackTrace();
                }
                log.info("截图保存至: [{}]", path);
                break;

            case "scriptSwipe":

                String[] maxXY = {String.valueOf(width), String.valueOf(height)};
                String[] tempScriptSwipe = step.getOperationValue().split("\\|", 2);
                if (null != tempScriptSwipe[0]) {
                    Double second = Double.valueOf(tempScriptSwipe[0]);
                    swipeObject.put("duration",  String.valueOf(second));

                    if (null != tempScriptSwipe[1] && !tempScriptSwipe[1].isEmpty()) {
                        String[] tempXY = tempScriptSwipe[1].split("\\|", 2);

                        String[] fromXY = tempXY[0].split(",", 2);
                        for (int i = 0; i < fromXY.length; ++i) {
                            if (fromXY[i].equals("-1")){
                                fromXY[i] = maxXY[i];
                            }
                            if (fromXY[i].isEmpty()) {
                                fromXY[i] = String.valueOf(Double.parseDouble(maxXY[i]) / 2);
                            }
                        }
                        swipeObject.put("fromX", Double.valueOf(fromXY[0]));
                        swipeObject.put("fromY",  Double.valueOf(fromXY[1]));

                        String[] toXY = tempXY[1].split(",", 2);
                        for (int i = 0; i < toXY.length; ++i) {
                            if (toXY[i].equals("-1")){
                                toXY[i] = maxXY[i];
                            }
                            if (toXY[i].isEmpty()) {
                                toXY[i] = String.valueOf(Double.parseDouble(maxXY[i]) / 2);
                            }
                        }

                        swipeObject.put("toX",  Double.valueOf(toXY[0]));
                        swipeObject.put("toY",  Double.valueOf(toXY[1]));

                        // swipeObject.put("direction",  "up");
                        ((JavascriptExecutor) appiumDriver).executeScript("mobile: dragFromToForDuration", swipeObject);
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    log.info("滑动页面参数有误 [{}:{}]", step.getOperation(), step.getOperationValue());
                    result = false;
                }
                break;

            case "goBack":
                swipeObject.put("duration",  "0.5");
                swipeObject.put("fromX", 0);
                swipeObject.put("fromY", String.valueOf(height / 2));
                swipeObject.put("toX",  width);
                swipeObject.put("toY",  String.valueOf(height / 2));
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }

        return result;
    }

}
