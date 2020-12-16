package com.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dto.PageDTO;

import com.exception.RestException;
import com.redis.DelayingQueueService;
import com.redis.dto.Message;
import com.security.JwtUser;
import com.sys.dto.UserSaveDto;
import com.sys.entity.SysUser;
import com.sys.mapper.SysUserMapper;
import com.sys.service.ISysUserService;
import com.sys.vo.UserInfoVo;
import com.sys.vo.UserPageVo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

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

    @Override
    public Page<UserPageVo> getUserPageVo(PageDTO dto, String userName, String account) {
        Page<UserPageVo> page = dto.createPage();
        List<UserPageVo> list = baseMapper.getUserPageVo(page,userName,account);
        return page.setRecords(list);
    }

    @Override
    public boolean saveUser(UserSaveDto dto) {
        SysUser sysUser= baseMapper.getUserByUsername(dto.getAccount());
        if (sysUser!=null && sysUser.getStatus()!=1){
            throw new RestException("该账号异已存在");
        }
        SysUser user = new SysUser();
        BeanUtils.copyProperties(dto,user);
        if(dto.getId()==null){
            user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        }
        boolean b = this.saveOrUpdate(user);
        // 删除该用户拥有的所有角色
        baseMapper.deleteAllUserRoleByUserId(user.getId());
        if(null!=dto.getRoleIds() && !dto.getRoleIds().isEmpty()){
            // 为该用户新增拥有的角色
            baseMapper.saveBatchUserRole(user.getId(),dto.getRoleIds());
        }
        return b;
    }

    @Override
    public UserInfoVo getUserInfoByUserId(Long id) {
        return baseMapper.getUserInfoByUserId(id);
    }

    @Override
    public void sendMessage(String msg, long delay,String channel) {

        String seqId = UUID.randomUUID().toString();
        Message message = new Message();
        //时间戳默认为毫秒 延迟5s即为 5*1000
        long time = System.currentTimeMillis();
        LocalDateTime dateTime = Instant.ofEpochMilli(time).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        message.setDelayTime(time + (delay * 1000));
        message.setCreateTime(dateTime);
        message.setBody(msg);
        message.setId(seqId);
        message.setChannel(channel);
        delayingQueueService.push(message);
    }
}
