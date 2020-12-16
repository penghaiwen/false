package com.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.sys.entity.SysMenu;
import com.sys.mapper.SysMenuMapper;
import com.sys.service.ISysMenuService;
import com.sys.vo.MenuTreeVo;
import com.sys.vo.MetaVO;
import com.sys.vo.RouterVO;
import com.utils.SubjectUtil;
import com.utils.ToTreeUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author 车资道科技
 * @since 2020-05-08
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List<MenuTreeVo> getMenuTree() {
        List<MenuTreeVo> all = baseMapper.getAllMenu();
        List<MenuTreeVo>  result = new ArrayList<>();
        try {
            result =   ToTreeUtils.toTree(all,"id");
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<RouterVO> getRouterTree() {
        System.out.println(SubjectUtil.getUserType());
        List<RouterVO> all = baseMapper.getRouterTree(SubjectUtil.getUserType()==0?null: SubjectUtil.getId());
        all.forEach(a->{
            a.setMeta(new MetaVO(a.getTitle(),a.getIcon(),a.getNoCache()));
            if(a.getMenuLevel()==1){
                a.setComponent("Layout");
            }
        });
        List<RouterVO>  result = new ArrayList<>();
        try {
            result =   ToTreeUtils.toTree(all,"id");
        }catch (Exception e){

        }
        return result;
    }
}
