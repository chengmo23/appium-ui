package com.chengmo.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


/**
 * Create by chengmo at 2022/10/18
 */

@Log4j2
@Data
@NoArgsConstructor
public class AppiumServer {

    public static AppiumDriverLocalService run() {
        AppiumDriverLocalService service = null;
        try{
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
            log.info("Appium server start...");

            if (!service.isRunning()){
               log.warn("Could not start REST http interface listener.");
            }else{
                log.info("Appium REST http interface listener started on {}", service.getUrl());
                service.clearOutPutStreams();
                service.enableDefaultSlf4jLoggingOfOutputData();
            }

            return service;
        }catch(Exception e){
            log.error("Could not start REST http interface listener.",e);
        }
        return service;
    }

    public static AppiumDriverLocalService run(String ip, int port) {
        AppiumDriverLocalService service = null;
        try{
            service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .withIPAddress(ip)
                    .usingPort(port)
                    .withArgument(GeneralServerFlag.LOG_LEVEL, "error")
                    .withArgument(GeneralServerFlag.SESSION_OVERRIDE));
            service.start();
            log.info("Appium server start...");

            if (!service.isRunning()){
                log.warn("Could not start REST http interface listener.");
            }else{
                log.info("Appium REST http interface listener started on {}:{}", ip, port);
                service.clearOutPutStreams();
                service.enableDefaultSlf4jLoggingOfOutputData();
            }

            return service;
        }catch(Exception e){
            log.error("Could not start REST http interface listener.",e);
        }
        return service;
    }

}
