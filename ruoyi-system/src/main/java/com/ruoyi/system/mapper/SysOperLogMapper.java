package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.SysOperLog;

/**
 * 操作日志 数据层
 *
 * @author ruoyi
 */

/**
 * 详细注释
 * @author Mxkun
 * 与操作相关的数据库操作
 * 与数据库连接的Mapper层接口，在编译的时候动态生成代理类，实现数据库查询功能
 */
public interface SysOperLogMapper {
    /**
     * 新增操作日志
     *
     * @param operLog 操作日志对象
     */
    public void insertOperlog(SysOperLog operLog);

    /**
     * 查询系统操作日志集合
     *
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    public List<SysOperLog> selectOperLogList(SysOperLog operLog);

    /**
     * 批量删除系统操作日志
     *
     * @param operIds 需要删除的操作日志ID
     * @return 结果
     */
    public int deleteOperLogByIds(Long[] operIds);

    /**
     * 查询操作日志详细
     *
     * @param operId 操作ID
     * @return 操作日志对象
     */
    public SysOperLog selectOperLogById(Long operId);

    /**
     * 清空操作日志
     */
    public void cleanOperLog();//通过truncate命令删除表中所有数据
}
