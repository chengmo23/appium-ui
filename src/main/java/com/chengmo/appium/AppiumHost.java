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
        this.ip = "127.0.0.1";
        this.port = 4723;
    }

    public AppiumHost(int port) {
        this.ip = "127.0.0.1";
        this.port = port;
    }
}
