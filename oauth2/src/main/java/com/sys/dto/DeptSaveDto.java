package com.sys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DeptSaveDto {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty(value = "机构名称")
    private String name;

    @ApiModelProperty(value = "排序")
    private Integer orderNum;


}
