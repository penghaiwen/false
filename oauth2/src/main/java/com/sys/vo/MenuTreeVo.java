package com.sys.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuTreeVo {
    @ApiModelProperty(value = "菜单ID")
    private Long id;

    @ApiModelProperty(value = "父ID")
    private Long parentId;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "菜单标题")
    private String menuTitle;

    @ApiModelProperty(value = "菜单备注")
    private String menuRemark;

    @ApiModelProperty(value = "权限字段")
    private String permsCode;

    @ApiModelProperty(value = "请求链接")
    private String menuUrl;

    @ApiModelProperty(value = "0-false 1-true")
    private Boolean keepAlive;

    @ApiModelProperty(value = "前端URL")
    private String menuPath;

    @ApiModelProperty(value = "图标")
    private String menuIcon;

    @ApiModelProperty(value = "排序字段")
    private Integer menuSort;

    @ApiModelProperty(value = "菜单级别 1-9级")
    private Integer menuLevel;

    @ApiModelProperty(value = "状态 0隐藏 1显示")
    private Boolean isShow;

    @ApiModelProperty(value = "子菜单")
    private List<MenuTreeVo> children;
    {
        children=  new ArrayList<>();
    }
}
