package com.ruoyi.chat.socket;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/17
 * @ClassName WebSocketServer
 * @Description:
 *      socketServer服务器，借助socket机制来实现用户之间的私聊聊天
 */
@ServerEndpoint(value = "/chat/myServer/{username}")
@Component
public class WebSocketServer {
    /**
     * <p> 变量描述如下:
     *
     * @Description:
     *      日志工具
     */
    private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    /**
     * <p> 变量描述如下:
     *
     * @Description:
     *      用来存储所有当前时间在线的用户
     */
    private static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *      当连接建立成功时，调用该函数，用以及时刷新用户列表
     *      具体功能是每个连接一旦建立，首先将他加到用户列表属性Map中，
     *      然后向所有用户（连同自己）发送更新后的用户列表用以前端展示
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        sessionMap.put(username, session);
        logger.info("有新用户加入，用户名为{}，当前在线总人数为{}", username, sessionMap.size());
        sendUserListToAllUsers();
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *      工具函数，用来实现对所有当前在线的用户发送群发信息
     */
    private void sendAllMessage(String message) {
        try {
            for (Session session : sessionMap.values()) {
                logger.info("服务器给客户【{}】发送消息，消息是{}", session.getId(), message);
                session.getBasicRemote().sendText(message);
            }
        } catch (Exception e) {
            logger.error("服务器给全部用户发送消息时发送失败");
        }
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *  当连接关闭时调用该方法，用于更新当前在线的用户列表
     *  具体功能是将该用户从存储中移除，并告知所有用户
     */
    @OnClose
    public void onClose(Session session, @PathParam("username") String username) {
        sessionMap.remove(username);
        logger.info("有一个用户脱离连接，该用户名为{},用户Id为{}，当前在线人数为{}", username, session.getId(), sessionMap.size());
        sendUserListToAllUsers();

    }


    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *      工具方法，用来实现将当前用户列表发送给所用客户
     */
    private void sendUserListToAllUsers() {
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        result.set("users", jsonArray);
        for (Object o : sessionMap.keySet()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.set("username", o);
            jsonArray.add(jsonObject);
        }
        sendAllMessage(JSONUtil.toJsonStr(result));
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *      当服务器收到客户发送来的一个消息后，便调用该方法，用以处理和中转用户发送的消息
     *      应为socket只能做到客户和本服务器之间的信息交互，所有想要实现客户之间的信息交互，必定需要服务器做中转
     */
    @OnMessage
    public void onMessage(String message, @PathParam("username") String username) {
        logger.info("服务器收到用户username={}发送来的消息：{}", username, message);
        JSONObject jsonObject = JSONUtil.parseObj(message);
        String destinationUsername = jsonObject.getStr("to");//目标用户名
        Session destinationSession = sessionMap.get(destinationUsername);
        if (destinationSession == null) {
            logger.info("发送失败，未找到目标客户username={}的session", destinationUsername);
        } else {
            if (jsonObject.getStr("function") == null) {//如果没有function字段，则书名该消息为常规的客户间的信息发送
                JSONObject jsonObject1 = new JSONObject();
                //重新组装消息，告知目标用户发送者
                jsonObject1.set("from", username);
                String text = jsonObject.getStr("text");//消息文本
                jsonObject1.set("text", text);
                sendMessage(jsonObject1.toString(), destinationSession);
            } else {
                String function = jsonObject.getStr("function");
                if (function.equals("leave")) {//当function字段为leave时，说明来源客户希望与目标客户断开交流
                    JSONObject jsonObject1 = new JSONObject();
                    //重新组装消息，告知目标用户发送者
                    jsonObject1.set("from", username);
                    jsonObject1.set("function", "leave");
                    sendMessage(jsonObject1.toString(), destinationSession);
                } else {//当function为link时，说明来源客户希望和目标客户建立交流
                    JSONObject jsonObject1 = new JSONObject();
                    //重新组装消息，告知目标用户发送者
                    jsonObject1.set("from", username);
                    jsonObject1.set("function", "link");
                    sendMessage(jsonObject1.toString(), destinationSession);
                }
            }
        }
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *      工具方法，向指定用户发送消息
     */
    private void sendMessage(String text, Session destinationSession) {
        try {
            destinationSession.getBasicRemote().sendText(text);
            logger.info("向用户id为{}的用户发送消息{}", destinationSession.getId(), text);
        } catch (IOException e) {
            logger.error("向用户id为{}的用户发送消息{}的活动失败", destinationSession.getId(), text);
        }
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *      发生错误时调用该方法
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("发生错误");
        error.printStackTrace();
    }


}
