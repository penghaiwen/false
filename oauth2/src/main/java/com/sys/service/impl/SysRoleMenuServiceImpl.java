package com.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.sys.entity.SysRoleMenu;
import com.sys.mapper.SysRoleMenuMapper;
import com.sys.service.ISysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色与菜单对应关系 服务实现类
 * </p>
 *
 * @author 老默
 * @since 2020-04-30
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

    @Override
    public boolean saveBatchRoleMenu(Long roleId, List<Long> menuIds) {
        // 先删除该角色下所有拥有的菜单
        baseMapper.deleteAllByRoleId(roleId);
        baseMapper.saveAllPerms(roleId, menuIds);
        return true;
    }
}
