package com.chengmo.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by chengmo at 2022/10/22
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Execute {

    private Integer id;
    private Integer taskId;
    private String taskName;
    private String clientInfo;
    private Integer status;
    private Integer caseCount;
    private Integer successCount;
    private Integer failCount;
    private Integer noExecCount;
    private String description;
    private String createBy;
    private String updateBy;

}
