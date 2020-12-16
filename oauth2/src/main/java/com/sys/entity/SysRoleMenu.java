package com.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* <p>
    * 角色与菜单对应关系
    * </p>
*
* @author 老默
* @since 2020-04-30
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("sys_role_menu")
    @ApiModel(value="SysRoleMenu对象", description="角色与菜单对应关系")
    public class SysRoleMenu extends Model<SysRoleMenu> {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "编号")
            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            @ApiModelProperty(value = "角色ID")
    private Long roleId;

            @ApiModelProperty(value = "菜单ID")
    private Long menuId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
