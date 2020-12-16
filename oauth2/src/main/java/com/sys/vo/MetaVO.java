package com.sys.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaVO {
    /**
     *@Author 老默
     *@Date 2019/6/13 10:54
     *@Description TODO
     */
    @ApiModelProperty(value = "名称{title：名称， icon  图标}")
    private String title;
    @ApiModelProperty(value = "名称{title：名称， icon  图标}")
    private String icon;
    private Boolean noCache;
}
