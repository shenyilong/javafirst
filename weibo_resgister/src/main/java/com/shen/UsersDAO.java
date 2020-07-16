package com.shen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsersDAO {
    public boolean trueFalse(String username,String password) {
        boolean Flag=false;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Users> list = new ArrayList<Users>();
        try
        {
            conn = DBHelper.getConnection();
            String sql = "select * from user;";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                Users user = new Users();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                if(username.equals(user.getUsername()) && password.equals(user.getPassword()))
                {
                    Flag=true;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
            {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            if (stmt != null)
            {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
        return Flag;
    }

    public int saveUsers(Users user) {
        int i = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        //	ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            String sql = "insert into user(username,password) value(?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            i = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null)
            {
                try {
                    stmt.close();
                    stmt = null;
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
        return i;
    }
}
