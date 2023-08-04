package com.chengmo;

import com.chengmo.appium.AppiumClient;
import com.chengmo.appium.AppiumHost;
import com.chengmo.appium.AppiumServer;
import com.chengmo.mapper.AppiumClientMapper;
import com.chengmo.mapper.StepMapper;
import com.chengmo.service.DriverService;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Create by chengmo at 2022/10/18
 */
@SpringBootTest
public class TestDemo {

    @Autowired
    DriverService DriverService;

    @Autowired
    AppiumClientMapper appiumClientMapper;

    @Autowired
    StepMapper stepMapper;


    @Test
    void contextLoads() {
    }

    @Test
    public void test0() throws MalformedURLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(BaseOptions.toW3cName("deviceName"), "iPhone 13 Pro Max");
        capabilities.setCapability(BaseOptions.toW3cName("platformName"), "iOS");
        capabilities.setCapability(BaseOptions.toW3cName("platformVersion"), "16.2");
        capabilities.setCapability(BaseOptions.toW3cName("automationName"), "XCUITest");
        capabilities.setCapability(BaseOptions.toW3cName("udid"), "00008110-000134190C13801E");
        capabilities.setCapability(BaseOptions.toW3cName("bundleId"), "com.zeekrlife.mobile");

        IOSDriver iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723"), capabilities);
        WebElement el = iosDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"我的\"]"));


        el.click();
        System.out.println("click");


    }

    @Test
    public void test1() throws MalformedURLException {
         AppiumDriverLocalService service = AppiumServer.run();

        int port = service.getUrl().getPort();

        AppiumDriver iosDriver = DriverService.initAppiumDriver(1, new AppiumHost(port));
        SessionId sessionId = iosDriver.getSessionId();
        System.out.println("sessionId： " + sessionId);
        WebElement el = iosDriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"我的\"]"));
        el.click();
        service.stop();
    }

    @Test
    public void select() {

        AppiumClient appiumClient = appiumClientMapper.findById(4);
        System.out.println(appiumClient);

    }

    @Test
    public void insert() {

        AppiumClient appiumCapabilitiesIOS = new AppiumClient();
        appiumCapabilitiesIOS.setDeviceName("iPhone 13 Pro Max");
        appiumCapabilitiesIOS.setPlatform(1);
        appiumCapabilitiesIOS.setPlatformName("iOS");
        appiumCapabilitiesIOS.setPlatformVersion("16.0");
        appiumCapabilitiesIOS.setUdid("00008110-0005390401D3801E");
        appiumCapabilitiesIOS.setBundleId("com.zeekrlife.mobile");
        appiumCapabilitiesIOS.setDescription("ChengMo's Test");
        appiumCapabilitiesIOS.setCreateBy("chengmo");

        Boolean success =  appiumClientMapper.addAppiumClient(appiumCapabilitiesIOS);
        System.out.println(success);

    }

    @Test
    public void update() {
        AppiumClient appiumCapabilitiesIOS = new AppiumClient();
        appiumCapabilitiesIOS.setId(4);
        appiumCapabilitiesIOS.setDeviceName("iPhone 14 Pro Max");
        appiumCapabilitiesIOS.setPlatform(1);
        appiumCapabilitiesIOS.setPlatformName("iOS");
        appiumCapabilitiesIOS.setPlatformVersion("17.0");
        appiumCapabilitiesIOS.setUdid("00008110-0005390401D3801E");
        appiumCapabilitiesIOS.setBundleId("com.zeekrlife.mobile");
        appiumCapabilitiesIOS.setDescription("ChengMo's TestModify");
        appiumCapabilitiesIOS.setNoReset(false);
        appiumCapabilitiesIOS.setNewCommandTimeout(3600);
        appiumCapabilitiesIOS.setImplicitlyWait(20);
        appiumCapabilitiesIOS.setUpdateBy("chengmo");

        Boolean success =  appiumClientMapper.updateAppiumClient(appiumCapabilitiesIOS);
        System.out.println(success);

    }

    @Test
    public void delete() {
        Boolean success =  appiumClientMapper.deleteAppiumClientById(new Integer[]{4});
        System.out.println(success);
    }

    @Test
    public void demo() {
        AppiumServer.run();
    }
}
