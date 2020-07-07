package com.shen.service.impl;

import com.shen.dao.IAccountDao;
import com.shen.dao.impl.AccountDaoImpl;
import com.shen.fuctory.BeanFactory;
import com.shen.service.IshenService;

public class AccountServiceImpl implements IshenService {
    //private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    //private int i = 1;
    //判断每次创建对象的时候是否是重新创建
    public void saveAccount(){
        int i= 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
