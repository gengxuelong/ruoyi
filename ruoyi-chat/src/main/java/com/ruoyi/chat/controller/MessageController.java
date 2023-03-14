package com.ruoyi.chat.controller;


import com.ruoyi.chat.pojo.Message;
import com.ruoyi.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/17
 * @ClassName MessageController
 * @Description:
 *      负责处理关于世界聊天大厅的功能请求
 */
@CrossOrigin
@RestController
@RequestMapping("chat")
public class MessageController {

    /**
     * <p> 变量描述如下:
     * @Description:
     *     service层自动注入
     */
    @Resource
    MessageService messageService;

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     拿到数据库中的所有世界大厅中的聊天记录
     */
    @RequestMapping("/hello")
    public List<Message> hello(){
        return messageService.getAllMessageFromDao();
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     将新法言的记录添加至数据库
     */
    @PostMapping("add")
    public String add(@RequestBody Message message){
        System.out.println(message.getUsername()+"------"+message.getText());
        messageService.addNewMessageToDao(message);
        return "发言成功";
    }
}
