package com.chengmo;

import com.chengmo.appium.AppiumClient;
import com.chengmo.appium.AppiumHost;
import com.chengmo.appium.AppiumServer;
import com.chengmo.handler.HandlerCompare;
import com.chengmo.handler.HandlerElement;
import com.chengmo.handler.HandlerPage;
import com.chengmo.mapper.AppiumClientMapper;
import com.chengmo.mapper.StepMapper;
import com.chengmo.pojo.Step;
import com.chengmo.service.DriverService;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.MalformedURLException;
import java.util.List;

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

    @Autowired
    HandlerElement handlerElement;

    @Autowired
    HandlerPage handlerPage;

    @Autowired
    HandlerCompare handlerCompare;


    @Test
    void contextLoads() {
    }

    @Test
    public void test0() throws MalformedURLException {

        // String ip = "10.114.40.224";
        String ip = "0.0.0.0";
        int port = 4723;
        AppiumHost appiumHost = new AppiumHost("10.114.35.120", port);

        AppiumDriver<MobileElement> iosDriver = DriverService.initIOSDriver(1, new AppiumHost());

        handlerElement.setNextHandler(handlerPage);
        handlerPage.setNextHandler(handlerCompare);

        List<Step> stepList = stepMapper.findByCaseId(2);
        for (Step step : stepList){
            handlerElement.HandleCheckNext(iosDriver, step);
        }
        HandlerCompare.clearResult();
    }

    @Test
    public void test1() throws MalformedURLException {
         AppiumDriverLocalService service = AppiumServer.run(4700);

        IOSDriver<MobileElement> iosDriver = DriverService.initIOSDriver(1, new AppiumHost());
        SessionId sessionId = iosDriver.getSessionId();
        System.out.println("sessionId： " + sessionId);

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
        System.out.println(1 + "|" + 294);
    }
}
