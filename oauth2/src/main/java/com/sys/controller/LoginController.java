package com.sys.controller;


import com.exception.RestBean;
import com.sys.service.ISysUserService;
import com.sys.vo.UserInfoVo;
import com.utils.SubjectUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/")
@RestController
@Api(tags = "登录")
@AllArgsConstructor
public class LoginController {
    @Resource
    private ISysUserService sysUserService;


    @GetMapping("get/info")
    @ApiOperation(value = "获取用户信息",notes = "老默",response = UserInfoVo.class )
    public RestBean getInfo(){
        UserInfoVo vo =sysUserService.getUserInfoByUserId(SubjectUtil.getId());
        return RestBean.ok(vo);
    }


    @DeleteMapping("oauth/user/logout")
    @ApiOperation(value = "退出登录",notes = "老默",response = RestBean.class )
    public RestBean logout(){
        return RestBean.ok();
    }






}
