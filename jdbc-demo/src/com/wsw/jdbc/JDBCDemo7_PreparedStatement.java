package com.wsw.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * @author loriyuhv
 * @ClassName JDBCDemo7_PreparedStatement
 * @date 2024/4/24 17:02
 * @description PreparedStatement
 * 好处：预编译SQL，性能更高；防止SQL注入，将敏感字符进行转义。
 */

public class JDBCDemo7_PreparedStatement {

    /**
     * @description 使用PreparedStatement预防SQL注入
     */
    @Test
    public void testPreparedStatement() throws SQLException {
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
        String sql = "select * from tb_user where username = ? and password = ?;";

        //4. 获取执行sql的对象 PreparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);


        //5. 执行sql
        ResultSet resultSet = preparedStatement.executeQuery();

        // 判断登录是否成功
        if(resultSet.next()) {
            System.out.println("登录成功！！！");
        } else {
            System.out.println("登录失败！！！");
        }

        //6. 释放资源
        preparedStatement.close();
        connection.close();
    }


    /**
     * @description PreparedStatement的原理
     */
    @Test
    public void testPreparedStatement2() throws SQLException, InterruptedException {
        //1. 注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取连接
        // useServerPrepStmts=true; // 开启预编译功能
        String url = "jdbc:mysql://127.0.0.1:3306/spring_db?useServerPrepStmts=true";
        String username = "root";
        String password = "0420";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 接收用户名和密码
        username = "loriyuhv";
        password = "' or '1' = '1";

        //3. 定义sql
        String sql = "select * from tb_user where username = ? and password = ?;";

        //4. 获取执行sql的对象 PreparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        Thread.sleep(30000);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = null;
        //5. 执行sql
        resultSet = preparedStatement.executeQuery();


        preparedStatement.setString(1, "zhangsan");
        preparedStatement.setString(2, "234");


        //5. 执行sql
        resultSet = preparedStatement.executeQuery();

        // 判断登录是否成功
        if(resultSet.next()) {
            System.out.println("登录成功！！！");
        } else {
            System.out.println("登录失败！！！");
        }

        //6. 释放资源
        preparedStatement.close();
        connection.close();
    }
}
