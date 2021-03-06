package com.shen.fuctory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 *
 * Bean：在计算机英语中，有可重用组件的含义。
 * JaveBean:用Java语言编写的可重组组件
 *     javabean > 实体类
 * 它就是创建我们的service和dao对象的。
 *
 * 第一个：需要一个配置文件来配置我们的service和dao
 *        配置的内容：唯一标识=全限定类名（key=value）
 * 第二个：通过读取配置文件中配置的内容，反射创建对象
 * 我的配置文件是xml也可以是properties
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;
    //定义一个Map，用于存放我们要创建的对象。我们把它称之为容器
    private static Map<String,Object> beans;
    //使用静态代码块为Properties对象赋值
    static{
        try{
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.Properties");
            props.load(in);
            beans = new HashMap<String,Object>();
            //取出配置文件中所有的key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                Object value    = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        }catch(Exception e ){
            throw new ExceptionInInitializerError("初始化失败");
        }
    }

    /**
     * 根据bean的名称获取对象     这个对象是单例对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
       return  beans.get(beanName);
    }

    /**
     * 根据Bean的名称获取bean对象          多例对象
     * @param beanName
     * @return

    public static Object getBean(String beanName){
        Object bean = null;
        try{
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
            //System.out.println(beanPath);

        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }*/
}
