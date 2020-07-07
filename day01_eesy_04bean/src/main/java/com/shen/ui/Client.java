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
     * @param aegs
     */
    public static void main(String[] aegs) {

//        1.获取核心容器的对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        2.根据id获取Bean对象
        IshenService as = (IshenService) ac.getBean("accountService");
        as.saveAccount();
    }
}
