package com.wsw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author loriyuhv
 * @ClassName JDBCDemo
 * @date 2024/4/24 15:27
 * @description JDBC入门案例
 */

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/spring_db";
        String username = "root";
        String password = "0420";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3. 定义sql
        String sql = "update user set age = 19 where id = 1";

        //4. 获取执行sql的对象 Statement
        Statement statement = connection.createStatement();

        //5. 执行sql
        int i = statement.executeUpdate(sql); // 受影响的函数
        System.out.println(i);

        //6. 释放资源
        statement.close();
        connection.close();
    }
}
