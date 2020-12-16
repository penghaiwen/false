package com.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.sys.entity.SysRole;
import com.sys.vo.RoleAllVo;
import com.sys.vo.RolePageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 老默
 * @since 2020-04-30
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     *功能描述
     * @author 老默
     * @date 2020/5/8
     * @time 17:22
     * @param page
     * @param roleName
     * @return java.util.List<com.example.demo.sys.vo.RolePageVo>
     */
    List<RolePageVo> getRolePageListByRoleName(@Param("page")Page<RolePageVo> page, @Param("roleName") String roleName);


    /**
     *功能描述
     * @author 老默
     * @date 2020/5/9
     * @time 9:52
     * @param
     * @return java.util.List<com.example.demo.sys.vo.RoleAllVo>
     */
    List<RoleAllVo> getRoleAll();
}
