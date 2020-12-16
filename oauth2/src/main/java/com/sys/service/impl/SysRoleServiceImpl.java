package com.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dto.PageDTO;

import com.sys.dto.RoleSaveDto;
import com.sys.entity.SysRole;
import com.sys.mapper.SysRoleMapper;
import com.sys.service.ISysRoleMenuService;
import com.sys.service.ISysRoleService;
import com.sys.vo.RoleAllVo;
import com.sys.vo.RolePageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 老默
 * @since 2020-04-30
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Resource
    private ISysRoleMenuService sysRoleMenuService;

    @Override
    public Page<RolePageVo> getRolePageListByRoleName(PageDTO dto, String roleName) {
        Page<RolePageVo> page =dto.createPage();
        List<RolePageVo> list=baseMapper.getRolePageListByRoleName(page,roleName);
        return page.setRecords(list);
    }

    @Override
    public boolean saveRole(RoleSaveDto dto) {
        SysRole role = new SysRole();
        role.setId(dto.getId());
        role.setName(dto.getRoleName());
        boolean b = this.saveOrUpdate(role);
        if(null !=dto.getMenuIds()&&!dto.getMenuIds().isEmpty()){
            sysRoleMenuService.saveBatchRoleMenu(role.getId(),dto.getMenuIds());
        }
        return b;
    }

    @Override
    public List<RoleAllVo> getRoleAll() {
        return baseMapper.getRoleAll();
    }
}
