package com.ruoyi.chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/17
 * @ClassName WebSocketConfig
 * @Description:
 */
@Configuration
public class WebSocketConfig {

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *      注册的这个类用以启动@ServerEndPoint注解
     *      spring的底层需要这个类的对象来处理@ServerEndPoint注解，
     *      我们后面需要在这个注解，所以需要加载这个类到spring容器中
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
