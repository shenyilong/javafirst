package com.shen.ui;

import com.shen.dao.IAccountDao;
import com.shen.fuctory.BeanFactory;
import com.shen.service.IshenService;
import com.shen.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
 public class Client {
    public static void main(String[] aegs){
        //IshenService as = new AccountServiceImpl();
        for(int i=0;i<5;i++){
            IshenService as = (IshenService)BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }

    }
}
