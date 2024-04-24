package com.wsw.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author loriyuhv
 * @ClassName JDBCDemo4_Statement
 * @date 2024/4/24 16:02
 * @description Statement作用：执行SQL语句
 * int executeUpdate(sql); 执行DML，DDL语句
 * ResultSet executeQuery(sql); 执行DQL语句
 * 返回值：ResultSet结果集对象
 */

public class JDBCDemo4_Statement {
    public static void main(String[] args) {
        System.out.println("Hello world!!!");
    }

    /**
     * @description 执行DDL语句
     */
    @Test
    public void testDDL() throws SQLException {
        //1. 注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/spring_db";
        String username = "root";
        String password = "0420";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3. 定义sql
        String sql = "create database jdbc_db;";
        // String sql = "drop database jdbc_db;";

        //4. 获取执行sql的对象 Statement
        Statement statement = connection.createStatement();

        //5. 执行sql
        int i = statement.executeUpdate(sql); // 受影响的函数
        System.out.println(i);

        //6. 释放资源
        statement.close();
        connection.close();
    }

    /**
     * @description 执行DML语句
     */
    @Test
    public void testDML() throws SQLException {
        //1. 注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/spring_db";
        String username = "root";
        String password = "0420";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3. 定义sql
        String sql = "update user set age = 22 where id = 10";

        //4. 获取执行sql的对象 Statement
        Statement statement = connection.createStatement();

        //5. 执行sql
        int i = statement.executeUpdate(sql); // 受影响的函数
        if (i > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }

        //6. 释放资源
        statement.close();
        connection.close();
    }
}
