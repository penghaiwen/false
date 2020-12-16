package com.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sys.entity.SysMenu;
import com.sys.vo.MenuTreeVo;
import com.sys.vo.RouterVO;


import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author 车资道科技
 * @since 2020-05-08
 */
public interface ISysMenuService extends IService<SysMenu> {
    
    /**
     *功能描述 获取菜单管理列表数据
     * @author 老默
     * @date 2020/5/8
     * @time 9:52
     * @param  
     * @return java.util.List<com.example.demo.sys.vo.MenuTreeVo>
     */
    List<MenuTreeVo> getMenuTree();

    /**
     *功能描述 获取前端菜单路由数据
     * @author 老默
     * @date 2020/5/8
     * @time 10:42
     * @param
     * @return java.util.List<com.example.demo.sys.vo.RouterVO>
     */
    List<RouterVO> getRouterTree();
}
