package com.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dto.PageDTO;

import com.sys.dto.DeptSaveDto;
import com.sys.entity.SysDept;
import com.sys.mapper.SysDeptMapper;
import com.sys.service.ISysDeptService;
import com.sys.vo.DeptPageVo;
import com.utils.SubjectUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 机构管理 服务实现类
 * </p>
 *
 * @author 老默
 * @since 2020-04-30
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

    @Override
    public Page<DeptPageVo> getDeptPageByDeptName(PageDTO dto, String deptName) {
        Page<DeptPageVo> page = dto.createPage();
        List<DeptPageVo> list = baseMapper.getDeptPageByDeptName(page,deptName);
        return page.setRecords(list);
    }

    @Override
    public boolean saveDept(DeptSaveDto dto) {
        System.out.println("id--"+ SubjectUtil.getId());
        SysDept sysDept=new SysDept();
        BeanUtils.copyProperties(dto,sysDept);
        return this.saveOrUpdate(sysDept);
    }
}
