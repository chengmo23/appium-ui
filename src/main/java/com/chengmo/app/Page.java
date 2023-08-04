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
public class Page {

    private Integer id;
    private String pageName;
    private Integer index;
    private Integer hasMenuBar;
    private Integer hsaTabBar;
    private Integer moduleId;
    private String description;
    private Integer orderNum;
    private String createBy;
    private String updateBy;
}
