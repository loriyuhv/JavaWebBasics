package com.wsw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author loriyuhv
 * @ClassName JDBCDdmo3_Connection
 * @date 2024/4/24 15:48
 * @description Connection 主要可以做两件事：
 * 一是创建sql执行对象
 * 二是事务管理
 */

public class JDBCDemo3_Connection {
    public static void main(String[] args) throws SQLException {
        // 1. 加载驱动

        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/spring_db";
        String username = "root";
        String password = "0420";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 3. 获取执行sql对象 Statement
        Statement statement = connection.createStatement();

        // 4. 定义sql
        String sql1 = "update user set age = 20 where id = 1";
        String sql2 = "update user set age = 20 where id = 2";

        try {
            // 开启事务
            // false 开启手动提交事务 true：自动提交事务（默认）
            connection.setAutoCommit(false);

            // 5. 执行sql
            int sql1Result = statement.executeUpdate(sql1);
            int i = 6/0;
            int sql2Result = statement.executeUpdate(sql2);

            // 6. 处理结果
            System.out.println(sql1Result);
            System.out.println(sql2Result);

            // 提交事务
            connection.commit();
        } catch (Exception e) {
            // 回滚事务
            connection.rollback();
            // throw new RuntimeException(e);
            e.printStackTrace();
        } finally {
            // 6. 关闭资源
            statement.close();
            connection.close();
        }
    }
}
