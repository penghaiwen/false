package com.sys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserSaveDto {
    @ApiModelProperty(value = "编号")
    private Long id;

    @ApiModelProperty(value = "用户名（账号）")
    private String account;

    @ApiModelProperty(value = "用户姓名")
    private String nickName;

    @ApiModelProperty(value = "用户类型（0 管理员 1专员）")
    private Integer userType;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "状态  0：禁用   1：正常")
    private Integer status;

    @ApiModelProperty(value = "机构ID")
    private Long deptId;

    @ApiModelProperty(value = "拥有的角色")
    private List<Long> roleIds;
}
