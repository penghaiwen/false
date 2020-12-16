package com.sys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class RoleSaveDto {
    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色拥有的菜单")
    private List<Long> menuIds;
}
