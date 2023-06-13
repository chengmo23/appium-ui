package com.chengmo.appium;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Create by chengmo at 2022/10/25
 */

@Data
@AllArgsConstructor
public class AppiumHost {

    private String ip;
    private int port;

    public AppiumHost(){
        this.ip = "0.0.0.0";
        this.port = 4723;
    }
}
