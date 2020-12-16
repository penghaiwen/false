package com.sys.vo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserInfoVo {
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("账号")
    private String userName;

    @ApiModelProperty("用户姓名")
    private String nickName;

    @ApiModelProperty("权限")
    @JSONField
    private String roleStr;

    @ApiModelProperty("权限")
    private List<Long> roles;
    {
        roles = new ArrayList<>();
    }
    public void setRoleStr(String roleStr) {
        this.roleStr = roleStr;
        if (!StringUtils.isBlank(roleStr)) {
            String[] strings = roleStr.split(",");
            for (String string : strings) {
                this.roles.add(Long.valueOf(string));
            }

        }
    }
}
