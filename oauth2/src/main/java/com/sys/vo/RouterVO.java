package com.sys.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class RouterVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "上级ID")
    private Long parentId;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "等级")
    @JsonIgnore
    private Integer menuLevel;

    @ApiModelProperty(value = "名称")
    private  String title;

    @ApiModelProperty(value = "路径")
    private String path;

    @ApiModelProperty(value = "组件")
    private String component;

    @ApiModelProperty(value = "组件")
    private String name;

    @ApiModelProperty(value = "名称{title：名称， icon  图标}")
    private MetaVO  meta;

    @ApiModelProperty(value = "是否缓存")
    private Boolean noCache;

    {
        children = new ArrayList<>();
    }
    private ArrayList<RouterVO> children;

}
