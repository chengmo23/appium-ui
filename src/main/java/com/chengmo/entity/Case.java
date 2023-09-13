package com.chengmo.entity;

import com.chengmo.entity.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Case {
    private Integer id;
    private String caseName;
    private Integer stepCount;
    private Integer initPageId;
    private Integer status;
    private Integer suitId;
}
