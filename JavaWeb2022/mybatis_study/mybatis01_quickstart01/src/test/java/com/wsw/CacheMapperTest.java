package com.wsw;

import com.wsw.mapper.CacheMapper;
import com.wsw.pojo.Brand;
import com.wsw.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author loriyuhv
 * @ClassName CacheMapperTest
 * @date 2024/4/25 19:49
 * @description TODO
 */

public class CacheMapperTest {
    /**
     * @description 测试情况一：同一个sqlSession范围，一级缓存
     */
    @Test
    public void testBrandById() throws IOException {
        Integer id = 2;

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);

        Brand brandById = cacheMapper.getBrandById(id);
        System.out.println(brandById);
        Brand brandById2 = cacheMapper.getBrandById(id);
        System.out.println(brandById2);

        sqlSession.close();
    }

    /**
     * @description 测试情况二：同一个sqlSession范围，一级缓存
     * 不同mapper对象
     */
    @Test
    public void testBrandById2() throws IOException {
        Integer id = 2;

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);
        CacheMapper cacheMapper2 = sqlSession.getMapper(CacheMapper.class);

        Brand brandById = cacheMapper.getBrandById(id);
        System.out.println(brandById);
        Brand brandById2 = cacheMapper2.getBrandById(id);
        System.out.println(brandById2);

        sqlSession.close();
    }

    // 使一级缓存失效的场景
    /**
     * @description  1) 不同的SqlSession对应不同的一级缓存
     * 测试情况一：不同的sqlSession范围，一级缓存
     * 不同mapper对象
     */
    @Test
    public void testBrandById4() throws IOException {
        Integer id = 2;

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();

        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);
        CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);

        Brand brandById = cacheMapper.getBrandById(id);
        System.out.println(brandById);

        Brand brandById2 = cacheMapper2.getBrandById(id);
        System.out.println(brandById2);

        sqlSession.close();
    }


    /**
     * @description 2) 同一个SqlSession但是查询条件不同
     * 测试情况二：同一个sqlSession范围，一级缓存 查询条件不同
     */
    @Test
    public void testBrandById3() throws IOException {
        Integer id = 2;
        Integer id2 = 3;
        String brandName = "%" + "华为" + "%";

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);

        Brand brandById = cacheMapper.getBrandById(id);
        System.out.println(brandById);
        Brand brandById2 = cacheMapper.getBrandById(id2);
        System.out.println(brandById2);

        Brand brandByName = cacheMapper.getBrandByName(brandName);
        System.out.println(brandByName);

        sqlSession.close();
    }

    /**
     * @description 3) 同一个SqlSession两次查询期间执行了任何一次增删改操作
     * 情况三：
     */
    @Test
    public void testBrandById5() throws IOException {
        Integer id = 2;
        Brand brand = new Brand();
        brand.setBrandName("Iphone");
        brand.setCompanyName("苹果科技有限公司");
        brand.setOrdered(200);
        brand.setDescription("智慧生活，改变你我他。");
        brand.setStatus(1);

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();

        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);

        Brand brandById = cacheMapper.getBrandById(id);
        System.out.println(brandById);

        Integer add = cacheMapper.add(brand);
        System.out.println(add);

        Brand brandById2 = cacheMapper.getBrandById(id);
        System.out.println(brandById2);

        sqlSession.close();
    }

    /**
     * @description 4) 同一个SqlSession两次查询期间手动清空了缓存
     */
    @Test
    public void testBrandById6() throws IOException {
        Integer id = 2;

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);

        Brand brandById = cacheMapper.getBrandById(id);
        System.out.println(brandById);
        sqlSession.clearCache();
        Brand brandById2 = cacheMapper.getBrandById(id);
        System.out.println(brandById2);

        sqlSession.close();
    }

    /**
     * @description 二级缓存数据缓存在SqlSessionFactory中
     */
    @Test
    public void testTwoCache() throws IOException {
        Integer id = 2;
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);

        Brand brandById = cacheMapper.getBrandById(id);
        System.out.println(brandById);
        sqlSession.commit();

        Brand brandById2 = cacheMapper2.getBrandById(id);
        System.out.println(brandById2);

        sqlSession.close();
    }
}
