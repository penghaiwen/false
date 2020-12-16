package com.sys.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserPageVo {
    @ApiModelProperty(value = "编号")
    private Long id;

    @ApiModelProperty(value = "用户姓名")
    private String nickName;

    @ApiModelProperty(value = "用户名")
    private String account;

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

    @ApiModelProperty(value = "机构名称")
    private String deptName;

    @ApiModelProperty(value = "拥有的角色")
    private String roleIds;

    @ApiModelProperty(value = "拥有的角色")
    private String roleNames;

    @ApiModelProperty(value = "创建人")
    private String createByName;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新人")
    private Long updateBy;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;

}
