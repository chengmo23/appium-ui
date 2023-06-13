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
public class Project {

    private Integer id;
    private String projectName;
    private Integer projectType;
    private String description;
    private Integer orderNum;
    private String createBy;
    private String updateBy;

}
