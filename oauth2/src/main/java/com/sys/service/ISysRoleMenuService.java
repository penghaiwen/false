package com.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.entity.SysRoleMenu;

import java.util.List;

/**
 * <p>
 * 角色与菜单对应关系 服务类
 * </p>
 *
 * @author 老默
 * @since 2020-04-30
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {

    /**
     *功能描述 批量保存
     * @author 老默
     * @date 2020/5/8
     * @time 17:28
     * @param roleId
     * @param menuIds
     * @return boolean
     */
    boolean saveBatchRoleMenu(Long roleId, List<Long> menuIds);
}
