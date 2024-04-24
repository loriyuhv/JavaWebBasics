package com.wsw.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * @author loriyuhv
 * @ClassName JDBCDemo6_UserLogin
 * @date 2024/4/24 16:47
 * @description 用户登录注册Sql注入
 */

public class JDBCDemo6_UserLogin {

    /**
     * @description 测试SQL注入
     */
    @Test
    public void testUserLoginInject() throws SQLException {
        //1. 注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/spring_db";
        String username = "root";
        String password = "0420";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 接收用户名和密码
        username = "loriyuhv";
        password = "' or '1' = '1";

        //3. 定义sql
        String sql = "select * from tb_user where username = '" + username + "' and password = '" + password + "'";
        System.out.println(sql);
        //4. 获取执行sql的对象 Statement
        Statement statement = connection.createStatement();

        //5. 执行sql
        ResultSet resultSet = statement.executeQuery(sql);

        // 判断登录是否成功
        if(resultSet.next()) {
            System.out.println("登录成功！！！");
        } else {
            System.out.println("登录失败！！！");
        }

        //6. 释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testUserLogin() throws SQLException {
        //1. 注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/spring_db";
        String username = "root";
        String password = "0420";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 接收用户名和密码
        username = "李四";
        password = "234";

        //3. 定义sql
        String sql = "select * from tb_user where username = '" + username + "' and password = '" + password + "'";

        //4. 获取执行sql的对象 Statement
        Statement statement = connection.createStatement();

        //5. 执行sql
        ResultSet resultSet = statement.executeQuery(sql);

        // 判断登录是否成功
        if(resultSet.next()) {
            System.out.println("登录成功！！！");
        } else {
            System.out.println("登录失败！！！");
        }

        //6. 释放资源
        statement.close();
        connection.close();
    }
}
