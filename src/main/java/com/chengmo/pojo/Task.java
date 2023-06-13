package com.chengmo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by chengmo at 2022/10/21
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private Integer id;
    private String taskName;
    private Integer jobId;
    private Integer projectId;
    private Integer planId;
    private Integer appiumClientId;
    private Integer timeout;
    private Integer noticeType;
    private String noticeAddress;
    private String description;
    private Integer orderNum;
    private String createBy;
    private String updateBy;

}
