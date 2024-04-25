package com.wsw;

import com.wsw.mapper.BrandMapper;
import com.wsw.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author loriyuhv
 * @ClassName BrandMapperTest
 * @date 2024/4/25 11:20
 * @description 针对BrandMapper SQL映射文件测试
 */

public class BrandMapperTest {

    @Test
    public void testSelectById() throws IOException {
        // 接收的参数
        Integer id = 1;

        // 1. 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行sql方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        // 5. 释放资源
        sqlSession.close();
    }
}
