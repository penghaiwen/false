package com.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dto.PageDTO;
import com.sys.dto.RoleSaveDto;
import com.sys.entity.SysRole;
import com.sys.vo.RoleAllVo;
import com.sys.vo.RolePageVo;


import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 老默
 * @since 2020-04-30
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     *功能描述 获取角色分页管理列表
     * @author 老默
     * @date 2020/5/8
     * @time 17:12
     * @param dto
     * @param roleName
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.example.demo.sys.vo.RolePageVo>
     */
    Page<RolePageVo> getRolePageListByRoleName(PageDTO dto, String roleName);

    /**
     *功能描述 保存角色信息
     * @author 老默
     * @date 2020/5/8
     * @time 17:13
     * @param dto
     * @return boolean
     */
    boolean saveRole(RoleSaveDto dto);

    /**
     *功能描述 获取所有角色信息
     * @author 老默
     * @date 2020/5/9
     * @time 9:51
     * @param
     * @return java.util.List<com.example.demo.sys.vo.RoleAllVo>
     */
    List<RoleAllVo> getRoleAll();
}
