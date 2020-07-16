package com.shen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/algorithm?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8";
    private static final String username="root";
    private static final String password="syl2000113";

    private static Connection conn=null;

    static
    {
        try
        {
            Class.forName(driver);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException
    {
        if(conn==null)
        {
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        return conn;
    }

    public static void main(String[] args)
    {
        try
        {
            Connection conn = DBHelper.getConnection();
            if(conn!=null)
            {
                System.out.println("数据库连接正常");
            }
            else
            {
                System.out.println("数据库连接异常");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
