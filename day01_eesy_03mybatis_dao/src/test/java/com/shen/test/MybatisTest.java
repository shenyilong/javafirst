package com.shen.test;

import com.shen.dao.IUserDao;
import com.shen.dao.impl.UserDaoImpl;
import com.shen.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;


public class MybatisTest {

    /**
     * @param args
     */
    public static void main(String[] args)throws Exception {
        InputStream in  = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        IUserDao userDao = new UserDaoImpl(factory);

        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }

        in.close();
    }
}
