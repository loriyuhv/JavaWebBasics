package com.wsw.jdbc;

import com.wsw.pojo.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author loriyuhv
 * @ClassName JDBCDemo5_ResultSet
 * @date 2024/4/24 16:20
 * @description
 * ResultSet(结果集对象)作用：
 * 1. 封装了DQL查询语句的结果
 * ResultSet statement.executeQuery(sql); 执行DQL语句，返回ResultSet对象。
 * 获取查询结果
 * boolean next(); 1)将光标从当前位置向前移动一行 2）判断当前行是否为有效行
 *  true: 有效行，当前行有数据；
 *  false: 有效行，当前行没有数据；
 *
 * xxx getXxx(参数); 获取数据
 * xxx:数据类型；如：int getInt(参数); String getString(参数);
 * 参数：
 *  int: 列的编号，从1开始
 *  String：列的名称
 *
 * 使用步骤；
 * 1. 游标向下移动一行，并判断该行是否有数据：next()
 * 2. 获取数据：getXxx(参数)
 * while(rs.next()){
 *     //获取数据
 *     rs.getXxx(参数);
 * }
 */

public class JDBCDemo5_ResultSet {

    /**
     * @description 查询user用户表数据，封装为User对象中，并且存储到ArrayList集合中
     */
    @Test
    public void testResultSet() throws SQLException {
        //1. 注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/spring_db";
        String username = "root";
        String password = "0420";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 3. 定义sql
        String sql = "select * from user;";

        // 4. 获取Statement对象
        Statement statement = connection.createStatement();

        // 5. 执行sql
        ResultSet resultSet = statement.executeQuery(sql);

        // 6. 处理结果
        ArrayList<User> users = new ArrayList<>();

        // 6.1 光标向下移动一行，并且判断当前行是否有数据
        while (resultSet.next()) {
            // 6.2 获取数据
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            int gender = resultSet.getInt("gender");
            String phone = resultSet.getString("phone");
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setAge(age);
            user.setGender(gender);
            user.setPhone(phone);
            users.add(user);
        }

        for (User user : users) {
            System.out.println(user);
        }
        // 7. 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }

    /**
     * @description 执行DQL语句
     */
    @Test
    public void testDQL() throws SQLException {
        //1. 注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/spring_db";
        String username = "root";
        String password = "0420";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 3. 定义sql
        String sql = "select * from user;";

        // 4. 获取Statement对象
        Statement statement = connection.createStatement();

        // 5. 执行sql
        ResultSet users = statement.executeQuery(sql);

        // 6. 处理结果
        // 6.1 光标向下移动一行，并且判断当前行是否有数据
        // while (users.next()) {
        //     // 6.2 获取数据
        //     int id = users.getInt(1);
        //     String name = users.getString(2);
        //     int age = users.getInt(3);
        //     int gender = users.getInt(4);
        //     String phone = users.getString(5);
        //     System.out.print(id + "--");
        //     System.out.print(name + "--");
        //     System.out.print(age + "--");
        //     System.out.print(gender + "--");
        //     System.out.print(phone + "--");
        //     System.out.println();
        // }

        while (users.next()) {
            // 6.2 获取数据
            int id = users.getInt("id");
            String name = users.getString("name");
            int age = users.getInt("age");
            int gender = users.getInt("gender");
            String phone = users.getString("phone");
            System.out.print(id + "--");
            System.out.print(name + "--");
            System.out.print(age + "--");
            System.out.print(gender + "--");
            System.out.print(phone + "--");
            System.out.println();
        }

        // 7. 释放资源
        users.close();
        statement.close();
        connection.close();
    }
}
