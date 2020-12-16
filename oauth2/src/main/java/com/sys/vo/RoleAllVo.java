package com.sys.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RoleAllVo {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;
}
