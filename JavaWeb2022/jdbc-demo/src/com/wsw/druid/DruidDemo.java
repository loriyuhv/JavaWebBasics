package com.wsw.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author loriyuhv
 * @ClassName DruidDemo
 * @date 2024/4/24 14:52
 * @description Druid数据库连接池演示
 */

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        // 1. 导入jar包

        // 2. 定义配置文件

        // 3. 加载配置文件
        Properties properties = new Properties();
        // properties.load(new FileInputStream("JavaWeb2022/src/druid.properties"));
        properties.load(new FileInputStream("../jdbc-demo/src/druid.properties"));
        // F:\IdeaProjects\Repositories\JavaWebBasics\JavaWeb2022
        // 4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        // 5. 获取数据库连接 Connection
        Connection connection = dataSource.getConnection();

        System.out.println(connection);

        System.out.println(System.getProperty("user.dir"));
    }
}
