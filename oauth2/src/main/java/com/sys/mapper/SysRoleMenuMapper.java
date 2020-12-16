package com.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sys.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色与菜单对应关系 Mapper 接口
 * </p>
 *
 * @author 老默
 * @since 2020-04-30
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
     *功能描述 根据角色ID删除所有菜单
     * @author 老默
     * @date 2020/5/8
     * @time 17:30
     * @param roleId
     * @return void
     */
    void deleteAllByRoleId(@Param("roleId")Long roleId);

    /**
     *功能描述 保存
     * @author 老默
     * @date 2020/5/8
     * @time 17:37
     * @param roleId
     * @param menuIds
     * @return void
     */
    void saveAllPerms(@Param("roleId")Long roleId,@Param("list") List<Long> menuIds);
}
