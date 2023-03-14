package com.ruoyi.chat.mapper;


import com.ruoyi.chat.pojo.Message;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/17
 * @ClassName MessageMapper
 * @Description:
 *      引入通用Mapper实现对message表的基本操作
 */
@Mapper
public interface MessageMapper extends tk.mybatis.mapper.common.Mapper<Message> {
}
