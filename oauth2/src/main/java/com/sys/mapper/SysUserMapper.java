package com.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;


public interface  SysUserMapper extends BaseMapper<SysUser> {

    /**
     * @Author 老默
     * @Description
     * @Date 2020/4/29 10:41
     * @param: userName
     * @return
     **/
    SysUser getUserByUsername(@Param("userName") String userName);


}
