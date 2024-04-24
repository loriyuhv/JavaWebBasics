package com.wsw;

import com.wsw.mapper.UserMapper;
import com.wsw.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
        // 获取SqlSessionFactory
        String mybatis = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(mybatis);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取SqlSession对象
        SqlSession sqlSession = build.openSession();

        // 执行sql
        // List<User> user = sqlSession.selectList("test.selectAll");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();

        // 输出结果
        for(User user : users) {
            System.out.println(user);
        }

        // 关闭资源
        sqlSession.close();
    }
}
