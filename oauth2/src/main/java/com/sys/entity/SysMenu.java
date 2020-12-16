package com.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
 * 菜单管理
 * </p>
 *
 * @author 车资道科技
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
@ApiModel(value="SysMenu对象", description="菜单管理")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单ID")
    @TableId(value = "id", type = IdType.AUTO)
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

    @ApiModelProperty(value = "删除标志： 0-正常 -1-删除")
    @TableLogic
    private Boolean deleteFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
