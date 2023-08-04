package com.chengmo.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by chengmo at 2022/10/21
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Element {

    private Integer id;
    private Integer platform;
    private String elementName;
    private String byType;
    private String elementValue;
    private Integer pageId;
    private Boolean status;
    private String description;
    private String createBy;
    private String updateBy;

}
