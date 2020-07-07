package com.shen.service.impl;


import com.shen.dao.IAccountDao;
import com.shen.dao.impl.AccountDaoImpl;
import com.shen.service.IshenService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IshenService {

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void  saveAccount(){
        System.out.println("service中的saveAccount方法执行了...");

    }
}