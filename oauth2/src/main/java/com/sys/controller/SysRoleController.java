package com.sys.controller;


import com.dto.PageDTO;

import com.exception.RestBean;
import com.sys.dto.RoleSaveDto;
import com.sys.service.ISysRoleService;
import com.sys.vo.RoleAllVo;
import com.sys.vo.RolePageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 老默
 * @since 2020-04-30
 */
@RestController
@RequestMapping("/api/sys/sys_role")
@Api(tags = "角色管理")
@Validated
public class SysRoleController {
    @Resource
    private ISysRoleService sysRoleService;


    @GetMapping("get/list")
    @ApiOperation(value = "获取角色分页列表",notes = "老默",response = RolePageVo.class)
    public RestBean getPageRoleList(PageDTO dto, String roleName){
        return RestBean.ok(sysRoleService.getRolePageListByRoleName(dto, roleName));
    }

    @PostMapping("save")
    @ApiOperation(value = "保存角色",notes = "老默",response = RestBean.class)
    public RestBean saveRole(RoleSaveDto dto){
        return RestBean.ok(sysRoleService.saveRole(dto));
    }


    @DeleteMapping("delete")
    @ApiOperation(value = "删除角色",notes = "老默",response = RestBean.class)
    public RestBean delRole(@Valid Long id){
        return RestBean.ok(sysRoleService.removeById(id));
    }


    @GetMapping("get/all_list")
    @ApiOperation(value = "获取所有角色数据",notes = "老默",response = RoleAllVo.class)
    public RestBean getAllList(){
        return RestBean.ok(sysRoleService.getRoleAll());
    }
}
