package com.sys.controller;



import com.exception.RestBean;
import com.sys.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


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

    @GetMapping("/list")
    @ApiOperation(value = "获取用户列表")
    public RestBean list(){
        return RestBean.ok(sysUserService.list());
    }



}
