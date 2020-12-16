package com.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.sys.entity.SysDept;
import com.sys.vo.DeptPageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 机构管理 Mapper 接口
 * </p>
 *
 * @author 车资道科技
 * @since 2020-04-30
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {
    /**
     *功能描述
     * @author 老默
     * @date 2020/5/8
     * @time 14:00
     * @param page
     * @param deptName
     * @return java.util.List<com.example.demo.sys.vo.DeptPageVo>
     */
    List<DeptPageVo> getDeptPageByDeptName(@Param("page") Page<DeptPageVo> page, @Param("deptName") String deptName);
}
