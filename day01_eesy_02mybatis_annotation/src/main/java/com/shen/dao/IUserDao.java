package com.shen.dao;

import com.shen.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
