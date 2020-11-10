package com.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.security.JwtUser;
import com.sys.entity.SysUser;


public interface ISysUserService extends IService<SysUser> {
    /**
     * @Author 老默
     * @Description 获取登录信息
     * @Date 2020/4/29 10:59
     * @param: userName
     * @return com.security.JwtUser
     **/
    JwtUser getUserByUsername(String userName);


}
