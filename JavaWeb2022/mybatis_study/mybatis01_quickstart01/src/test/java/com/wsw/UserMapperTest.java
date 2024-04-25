package com.wsw;

import com.wsw.mapper.UserMapper;
import com.wsw.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;

/**
 * @author loriyuhv
 * @ClassName UserMapperTest
 * @date 2024/4/24 23:19
 * @description UserMapperTest测试类
 */

public class UserMapperTest {

    @Test
    public void testSelect() throws IOException {
        // 接收参数
        String username = "李四";
        String password = "234";

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取Mapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 4. 执行方法
        // User user = userMapper.select(username, password);
        // System.out.println(user);

        User user = userMapper.select(new HashSet());
        System.out.println(user);

        // 5. 释放资源
        sqlSession.close();
    }


    @Test
    public void testSelectById() throws IOException {
        // 接收参数
        Integer id = 1;

        // 1. 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4. 执行sql方法
        User user = userMapper.selectById(id);
        System.out.println(user);
        // 5. 释放资源
        sqlSession.close();
    }
}
