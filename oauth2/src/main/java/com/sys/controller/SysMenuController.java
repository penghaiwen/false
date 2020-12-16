package com.sys.controller;



import com.exception.RestBean;
import com.sys.entity.SysMenu;
import com.sys.service.ISysMenuService;
import com.sys.vo.MenuTreeVo;
import com.sys.vo.RouterVO;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author 老默
 * @since 2020-05-08
 */
@RestController
@RequestMapping("/api/sys/sys_menu")
@Api(tags = "菜单管理")
@Validated
public class SysMenuController {
    @Resource
    private ISysMenuService sysMenuService;


    @PostMapping("save")
    @ApiOperation(value = "保存菜单",notes = "老默",response = RestBean.class)
    public RestBean add(SysMenu menu){
        return RestBean.ok(sysMenuService.saveOrUpdate(menu));
    }

    @DeleteMapping("delete")
    @ApiOperation(value = "删除菜单",notes = "老默",response = RestBean.class)
    public RestBean add(@ApiParam(value = "菜单id")Long id){
        return RestBean.ok(sysMenuService.removeById(id));
    }

    @GetMapping("get/menu_tree")
    @ApiOperation(value = "获取菜单管理列表",notes = "老默",response = MenuTreeVo.class)
    public RestBean getMenuTree(){
        return RestBean.ok(sysMenuService.getMenuTree());
    }


    @PutMapping("update/show")
    @ApiOperation(value = "修改显示、隐藏",notes = "老默",response = RestBean.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "菜单id",required = true),
            @ApiImplicitParam(name = "isShow", value = "状态 0隐藏 1显示",required = true),
    })
    public RestBean add(@Valid Long id,  Integer isShow){
        SysMenu menu = sysMenuService.getById(id);
        menu.setIsShow(isShow==0?false:true);
        return RestBean.ok(sysMenuService.updateById(menu));
    }



    @GetMapping("get/router_tree")
    @ApiOperation(value = "获取菜单路由",notes = "老默",response = RouterVO.class)
    public RestBean getRouterTree(){
        return RestBean.ok(sysMenuService.getRouterTree());
    }

}
