package com.sys.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RolePageVo {
    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("角色拥有的菜单")
    private String menuIds;
}
