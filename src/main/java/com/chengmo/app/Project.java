package com.chengmo.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private String createBy;
    private Date createdAt;
    private String updateBy;
    private Date updatedAt;
}
