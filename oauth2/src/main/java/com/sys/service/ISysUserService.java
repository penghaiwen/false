package com.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dto.PageDTO;

import com.security.JwtUser;
import com.sys.dto.UserSaveDto;
import com.sys.entity.SysUser;
import com.sys.vo.UserInfoVo;
import com.sys.vo.UserPageVo;


public interface ISysUserService extends IService<SysUser> {
    /**
     * @Author 老默
     * @Description 获取登录信息
     * @Date 2020/4/29 10:59
     * @param: userName
     * @return com.security.JwtUser
     **/
    JwtUser getUserByUsername(String userName);

    /**
     * @Author 老默
     * @Description
     * @param dto
     * @param userName
     * @return
     */
    Page<UserPageVo> getUserPageVo(PageDTO dto, String userName, String account);
    
    /**
     *功能描述 保存用户信息
     * @author 老默
     * @date 2020/5/9
     * @time 9:16
     * @param dto
     * @return boolean
     */
    boolean saveUser(UserSaveDto dto);

    /**
     *功能描述 
     * @author 老默
     * @date 2020/5/9
     * @time 17:56
     * @param id 
     * @return com.example.demo.sys.vo.UserInfoVo
     */
    UserInfoVo getUserInfoByUserId(Long id);

    void sendMessage(String msg,long delay, String channel);
}
