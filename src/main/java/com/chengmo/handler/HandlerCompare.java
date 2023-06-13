package com.chengmo.handler;

import com.chengmo.pojo.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by chengmo at 2022/10/26
 */

@Log4j2
@Component
public class HandlerCompare extends Handler {

    private static final Map<Integer, String> resultMap = new HashMap<>();


    public static void saveResult(Step step, String result) {
        resultMap.put(step.getStepNumber(), result);
    }

    public static void clearResult() {
        resultMap.clear();
    }

    private String getCurrentResult(Step step) {
        return resultMap.get(step.getStepNumber());
    }

    private String getResult(Integer stepNumber) {
        return resultMap.get(stepNumber);
    }

    @Override
    public Boolean operation(AppiumDriver<MobileElement> appiumDriver, Step step) {

        if (step.getExpected() == null || step.getExpected().isEmpty()) {
            return true;
        }

        boolean result;

        // 步骤结果匹配
        if (step.getExpected().length() > "$=".length() && step.getExpected().startsWith("$=")) {
            String id = step.getExpected().substring("$=".length());
            Integer stepNumber = Integer.parseInt(id);
            result = getCurrentResult(step).equals(getResult(stepNumber));
            log.info("期望值: [{}], 实际值: [{}], 对比结果: [{}]", getResult(stepNumber), getCurrentResult(step), result);
        }
        // 正则匹配
        else if (step.getExpected().length() > "~=".length() && step.getExpected().startsWith("~=")) {
            Pattern pattern = Pattern.compile(step.getExpected().substring("~=".length()));
            Matcher matcher = pattern.matcher(getCurrentResult(step));
            result = matcher.find();
            log.info("期望值: [{}], 实际值: [{}], 对比结果: [{}]", step.getExpected(), getCurrentResult(step), result);
        }
        // 模糊匹配
        else if (step.getExpected().length() > "%=".length() && step.getExpected().startsWith("%=")) {
            result = getCurrentResult(step).contains(step.getExpected().substring("%=".length()));
            log.info("期望值: [{}], 实际值: [{}], 对比结果: [{}]", step.getExpected(), getCurrentResult(step), result);
        }
        // 精确匹配
        else {
            result = getCurrentResult(step).equals(step.getExpected());
            log.info("期望值: {}, 实际值: {}, 对比结果: {}", step.getExpected(), getCurrentResult(step), result);
        }

        return result;
    }

}
