package com.sys.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DeptPageVo {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty(value = "机构名称")
    private String name;

    @ApiModelProperty(value = "排序")
    private Integer orderNum;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private String createTime;
}
