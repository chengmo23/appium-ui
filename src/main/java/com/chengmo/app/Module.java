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
public class Module {

    private Integer id;
    private String moduleName;
    private Integer projectId;
    private String description;
    private Integer orderNum;
    private String createBy;
    private Date createdAt;
    private String updateBy;
    private Date updatedAt;
}
