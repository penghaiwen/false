package com.sys.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exception.RestException;
import com.redis.DelayingQueueService;
import com.security.JwtUser;
import com.sys.entity.SysUser;
import com.sys.mapper.SysUserMapper;
import com.sys.service.ISysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl  extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private DelayingQueueService delayingQueueService;
    @Override
    public JwtUser getUserByUsername(String userName) {
        SysUser user= baseMapper.getUserByUsername(userName);
        if (user.getStatus()!=1){
            throw new RestException("该账号异常，请联系管理员");
        }
        JwtUser jwtUser =new JwtUser();
        BeanUtils.copyProperties(user,jwtUser);
        jwtUser.setUsername(user.getAccount());
        return jwtUser;
    }



}
