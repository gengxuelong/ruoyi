package com.ruoyi.chat.config;

import com.ruoyi.chat.filter.EncodingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GengXuelong
 * @version 1.0
 * @Mail 3349495429@qq.com
 * @Date 2022/12/18
 * @ClassName WebMvcConfig
 * @Description:
 */
@Configuration
public class WebMvcConfig {

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * @Description:
     *     将自定义的过滤器注册到spring容器中
     */
    @Bean
    public FilterRegistrationBean<EncodingFilter> registerFilter(){
        FilterRegistrationBean<EncodingFilter> registrationBean = new FilterRegistrationBean<EncodingFilter>();
        registrationBean.setFilter(new EncodingFilter());
        /*
        设置过滤器的工作方位，即过滤一切请求
         */
        registrationBean.addUrlPatterns("/*");
        /*
        设置过滤器的名字，为防止和spring容器中引入依赖中已存在的过滤器重名，所以多加了一个1后缀
         */
        registrationBean.setName("Filter1");
        /*
        设置过滤器的过滤执行优先级，spring底层会按order大小从小到大以此执行过滤器，默认order为int的最大值，
        设置为1，基本可以代表第一个执行或者较为首先得执行该过滤器
         */
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
