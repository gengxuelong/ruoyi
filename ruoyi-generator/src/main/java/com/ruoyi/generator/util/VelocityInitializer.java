package com.ruoyi.generator.util;

import java.util.Properties;
import org.apache.velocity.app.Velocity;
import com.ruoyi.common.constant.Constants;

/**
 * VelocityEngine工厂
 * 使用VelocityEngine工厂可以辅助生成HTML页面 还有 Java代码
 * @author ruoyi
 */
public class VelocityInitializer
{
    /**
     * 初始化vm方法
     */
    public static void initVelocity()
    {
        Properties p = new Properties();
        try
        {
            // 加载classpath目录下的vm文件
            // resource.loader.file.class=org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader
            p.setProperty("resource.loader.file.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

            // 定义字符集
            //Velocity.INPUT_ENCODING=Constants.UTF8 设置velocity模板引擎的字符编码为UTF-8
            p.setProperty(Velocity.INPUT_ENCODING, Constants.UTF8);

            // 初始化Velocity引擎，指定配置Properties
            //加载p
            Velocity.init(p);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
