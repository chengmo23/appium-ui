package com.chengmo.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by chengmo at 2022/10/21
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    private Integer id;
    private String jobName;
    private String cronExpression;
    private Integer status;
    private String description;
    private Integer orderNum;
    private String createBy;
    private String updateBy;

}
