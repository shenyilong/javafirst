package com.shen.ui;

import com.shen.dao.IAccountDao;
import com.shen.service.IshenService;
import com.shen.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * 获取spring的IOC核心容器，并根据id获取对象
     *ApplicationContest的三个常用实现类
     *      ClassPathXmlApplicationContext:它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。
     *      FileSystemXmlApplicationContext:它可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext:它是用于读取注解创建容器的。
     * 核心容器的两个接口引发出的问题：
     * ApplicationContext:
     *      它在构建核心容器时，创建对象采用的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就能创建配置文件中的配置对象。
     * BeanFactory:
     *      它在构建核心容器时，创建对象采用的策略是采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才是真正的创建对象。
     * @param aegs
     */
    public static void main(String[] aegs){

//        IshenService as = new AccountServiceImpl();
//         IshenService as = (IshenService)BeanFactory.getBean("accountService");
//        1.获取核心容器的对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\沈一龙\\Desktop\\bean.xml");
//        2.根据id获取Bean对象
        //IshenService as  = (IshenService)ac.getBean("accountService");
        //IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
        //System.out.println(as);
        //System.out.println(adao);
        //as.saveAccount();
        //----------BeanFactory--------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IshenService as  = (IshenService)factory.getBean("accountService");
        System.out.println(as);

    }
}