package com.wsw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author loriyuhv
 * @ClassName JDBCDemo2_DriverManager
 * @date 2024/4/24 15:41
 * @description DriverManager MySqL驱动管理
 */

public class JDBCDemo2_DriverManager {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 获取连接
        // String url = "jdbc:mysql://127.0.0.1:3306/spring_db";
        String url = "jdbc:mysql:///spring_db";
        String username = "root";
        String password = "0420";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 3. 编写sql
        String sql = "update user set age = 19 where id = 1";

        // 4. 获取执行sql对象 Statement
        Statement statement = connection.createStatement();

        // 5. 执行sql
        int i = statement.executeUpdate(sql);
        System.out.println(i);

        // 6. 关闭资源
        statement.close();
        connection.close();
    }
}
