package com.sys.controller;


import com.dto.PageDTO;

import com.exception.RestBean;
import com.sys.dto.UserSaveDto;
import com.sys.service.ISysUserService;
import com.sys.vo.UserPageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author 老默
 * @since 2020-04-30
 */
@RestController
@RequestMapping("/api/sys/sys_user")
@Api(tags = "用户管理")
@Validated
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    @GetMapping("get/list")
    @ApiOperation(value = "获取用户管理分页列表数据",notes = "老默",response = UserPageVo.class)
    public RestBean getList(PageDTO dto,String nickName,  String account){
        return RestBean.ok(sysUserService.getUserPageVo(dto,nickName,account));
    }

    @PostMapping("save")
    @ApiOperation(value = "保存用户信息",notes = "老默",response = RestBean.class)
    public RestBean save(UserSaveDto dto){
        return RestBean.ok(sysUserService.saveUser(dto));
    }


    @DeleteMapping("delete")
    @ApiOperation(value = "删除用户信息",notes = "老默",response = RestBean.class)
    public RestBean delete(@ApiParam(value = "用户ID")Long id){
        return RestBean.ok(sysUserService.removeById(id));
    }


    @PutMapping("update/pwd")
    @ApiOperation(value = "修改密码",notes = "",response = RestBean.class)
    public RestBean updatePwd(@NotNull Long userId,
                             @NotBlank String oldPwd,
                             @NotNull String newPwd){
        return RestBean.ok();
    }


}
