package com.chengmo.handler;

import com.chengmo.pojo.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Point;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Create by chengmo at 2022/10/22
 */
@Component
@Log4j2
public class HandlerElement extends Handler {

    @Override
    public Boolean operation(AppiumDriver<MobileElement> appiumDriver, Step step) {

        if (!step.getOperationType().equals(1)) {
            return true;
        }

        boolean result = true;

        List<MobileElement> elementList = findElements(appiumDriver, step);
        log.info("通过 [{}:{}] 定位到{}个元素", step.getElementType(), step.getElement(), elementList.size());
        if (step.getOperation().equals("count")) {
            HandlerCompare.saveResult(step, String.valueOf(elementList.size()));
            return true;
        }
        if (step.getElementIndex() >= elementList.size()) {
            log.info("未定位到元素 或 元素超出索引范围");
            return false;
        }

        switch (step.getOperation()) {
            case "click":
                elementList.get(step.getElementIndex()).click();
                log.info("{}", step.getStepName());
                break;

            case "sendKeys":
                elementList.get(step.getElementIndex()).sendKeys(step.getOperationValue());
                log.info("{}: [{}] ", step.getStepName(), step.getOperationValue());
                break;

            case "clear":
                elementList.get(step.getElementIndex()).clear();
                log.info("清除数据");
                break;

            case "getText":
                HandlerCompare.saveResult(step, elementList.get(step.getElementIndex()).getText());
                log.info("获取到元素文本: [{}] ", elementList.get(step.getElementIndex()).getText());
                break;

            case "getAttribute":
                HandlerCompare.saveResult(step, elementList.get(step.getElementIndex()).getAttribute(step.getOperationValue()));
                log.info("获取{}属性值: [{}]", step.getOperationValue(), elementList.get(step.getElementIndex()).getAttribute(step.getOperationValue()));
                break;

            case "getLocation":
                Point location = elementList.get(step.getElementIndex()).getLocation();
                HandlerCompare.saveResult(step, location.getX() + "|" + location.getY());
                log.info("获取元素坐标: [{}]", location.getX() + "|" + location.getY());
                break;
        }

        return result;
    }

    public List<MobileElement> findElements(AppiumDriver<MobileElement> appiumDriver, Step step) {
        if ((!step.getElementType().isEmpty() || step.getElementType() == null )&& (!step.getElement().isEmpty() ||  step.getElement() == null)) {
            return appiumDriver.findElements(step.getElementType(), step.getElement());
        } else {
            log.info("元素定位参数有误 [{}:{}]", step.getElementType(), step.getElement());
            return null;
        }
    }




}
