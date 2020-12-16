package com.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dto.PageDTO;
import com.sys.dto.DeptSaveDto;
import com.sys.entity.SysDept;
import com.sys.vo.DeptPageVo;


/**
 * <p>
 * 机构管理 服务类
 * </p>
 *
 * @author 车资道科技
 * @since 2020-04-30
 */
public interface ISysDeptService extends IService<SysDept> {

    /**
     *功能描述 查询机构分页信息
     * @author 老默
     * @date 2020/5/8
     * @time 13:54
     * @param dto
     * @param deptName
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.example.demo.sys.vo.DeptPageVo>
     */
    Page<DeptPageVo> getDeptPageByDeptName(PageDTO dto, String deptName);

    /**
     *功能描述 保存机构信息
     * @author 老默
     * @date 2020/5/8
     * @time 13:55
     * @param dto
     * @return boolean
     */
    boolean saveDept(DeptSaveDto dto);
}
