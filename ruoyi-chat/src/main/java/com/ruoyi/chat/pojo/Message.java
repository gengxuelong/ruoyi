package com.ruoyi.chat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/17
 * @ClassName Message
 * @Description:
 *      message表对应的Java实体类，对应世界聊天大厅中的聊天记录，私聊的记录不经过数据库
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String username;
    private String text;
    public Message(String username,String text){
        this.username = username;
        this.text = text;
    }
}
