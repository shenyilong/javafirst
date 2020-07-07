package com.itheima.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序的耦合
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?useSSL=false","root","syl2000113");
        PreparedStatement pstm = conn.prepareStatement("SELECT  * FROM account");
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        rs.close();
        pstm.close();
        conn.close();

    }
}
