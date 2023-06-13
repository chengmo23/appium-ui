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
public class Step {

    private Integer id;
    private Integer pageId;
    private Integer caseId;
    private Integer stepNumber;
    private String stepName;
    private Integer operationType;
    private String operation;
    private String operationValue;
    private String elementType;
    private String element;
    private Integer elementIndex;
    private String expected;
    private Boolean status;
    private String description;
    private Integer orderNum;
    private String createBy;
    private String updateBy;

}
