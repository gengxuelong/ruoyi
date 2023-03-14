package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.SysRoleDept;

/**
 * 角色与部门关联表 数据层
 *
 * @author ruoyi
 */

/**
 * 详细注释
 * @author Mxkun
 * 与角色与部门关联表相关的数据库操作
 * 与数据库连接的Mapper层接口，在编译的时候动态生成代理类，实现数据库查询功能
 */
public interface SysRoleDeptMapper {
    /**
     * 通过角色ID删除角色和部门关联
     *
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteRoleDeptByRoleId(Long roleId);

    /**
     * 批量删除角色部门关联信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRoleDept(Long[] ids);

    /**
     * 查询部门使用数量
     *
     * @param deptId 部门ID
     * @return 结果
     */
    public int selectCountRoleDeptByDeptId(Long deptId);

    /**
     * 批量新增角色部门信息
     *
     * @param roleDeptList 角色部门列表
     * @return 结果
     */
    public int batchRoleDept(List<SysRoleDept> roleDeptList);
}
