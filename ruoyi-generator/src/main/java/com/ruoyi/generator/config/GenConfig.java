package com.ruoyi.generator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 读取代码生成相关配置
 * 这里主要读取generator.yml 并且 绑定gen前缀下的资源
 * @author ruoyi
 */
@Component //注册为spring bean
@ConfigurationProperties(prefix = "gen")//指定gen前缀绑定配置文件中的配置
@PropertySource(value = { "classpath:generator.yml" })//指定资源文件读取的位置
public class GenConfig
{
    /** 作者 */
    public static String author;

    /** 生成包路径 */
    public static String packageName;

    /** 自动去除表前缀，默认是false */
    public static boolean autoRemovePre;

    /** 表前缀(类名不会包含表前缀) */
    public static String tablePrefix;

    /**
     * 获取作者名称
     * @return 作者名称
     */
    public static String getAuthor()
    {
        return author;
    }

    /**
     * 注入gen.author
     * @param author 作者名称
     */
    @Value("${author}")
    public void setAuthor(String author)
    {
        GenConfig.author = author;
    }


    /**
     * 获取包名
     * @return 包名
     */
    public static String getPackageName()
    {
        return packageName;
    }

    /**
     * 注入包名
     * @param packageName 包名
     */
    @Value("${packageName}")
    public void setPackageName(String packageName)
    {
        GenConfig.packageName = packageName;
    }

    /**
     * 获取是否自动去除前缀
     * @return
     */
    public static boolean getAutoRemovePre()
    {
        return autoRemovePre;
    }

    /**
     * 注入是否自动去除前缀
     * @param autoRemovePre 自动去除前缀
     */
    @Value("${autoRemovePre}")
    public void setAutoRemovePre(boolean autoRemovePre)
    {
        GenConfig.autoRemovePre = autoRemovePre;
    }

    /**
     * 获取表前缀
     * @return 表前缀
     */
    public static String getTablePrefix()
    {
        return tablePrefix;
    }

    /**
     * 注入表前缀
     * @param tablePrefix 表前缀
     */
    @Value("${tablePrefix}")
    public void setTablePrefix(String tablePrefix)
    {
        GenConfig.tablePrefix = tablePrefix;
    }
}
