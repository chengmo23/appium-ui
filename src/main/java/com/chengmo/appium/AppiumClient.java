package com.chengmo.appium;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by chengmo at 2022/10/18
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppiumClient {

    private Integer id;
    private String deviceName;
    private Integer platform;
    private String platformName;
    private String platformVersion;
    private String udid;
    private String bundleId;
    private String appPackage;
    private String appActivity;
    private Boolean noReset;
    private Integer newCommandTimeout;
    private Integer implicitlyWait;
    private String description;
    private String createBy;
    private String updateBy;

    public Map<String, Object> getCapabilitiesMap() {
        Map<String, Object> capabilitiesMap = new HashMap<>();

        capabilitiesMap.put("deviceName", deviceName);
        capabilitiesMap.put("platformName", platformName);
        capabilitiesMap.put("platformVersion", platformVersion);
        capabilitiesMap.put("automationName", platform == 1 ? "XCUITest" : "UiAutomator2");
        capabilitiesMap.put("udid", udid);
        capabilitiesMap.put("bundleId", bundleId);
        capabilitiesMap.put("appPackage", appPackage);
        capabilitiesMap.put("appActivity", appActivity);
        capabilitiesMap.put("noReset", noReset);
        capabilitiesMap.put("newCommandTimeout", newCommandTimeout);
        capabilitiesMap.put("implicitlyWait", implicitlyWait);

        return capabilitiesMap;
    }
}
