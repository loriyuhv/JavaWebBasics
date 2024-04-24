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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author loriyuhv
 * @ClassName MyBatisTest
 * @date 2024/4/24 19:57
 * @description TODO
 */

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {
        // 1. 获取SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        for (Brand brand : brands) {
            System.out.println(brand);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectByIdBrand() throws IOException {
        // 接收参数
        int id = 1;

        // 1. 获取SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        Brand brand = mapper.selectByIdBrand(id);
        System.out.println(brand);

        // 5. 关闭资源
        sqlSession.close();
    }

    /**
     * @description 多条件动态查询
     */
    @Test
    public void testSelectByCondition() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 封装对象
        Brand brand1 = new Brand();
        brand1.setStatus(status);
        brand1.setCompanyName(companyName);
        brand1.setBrandName(brandName);

        // 封装map
        HashMap<Object, Object> brand2 = new HashMap<>();
        // brand2.put("status", status);
        brand2.put("companyName", companyName);
        // brand2.put("brandName", brandName);

        // 1. 获取SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        // 散装参数
        // List<Brand> brands = mapper.selectByCondition(status, companyName, brandName);
        // 对象参数
        // List<Brand> brands = mapper.selectByCondition(brand1);
        // map参数
        List<Brand> brands = mapper.selectByCondition(brand2);

        for (Brand brand : brands) {
            System.out.println(brand);
        }

        // 5. 关闭资源
        sqlSession.close();
    }


    /**
     * @description 单条件动态查询
     */
    @Test
    public void testSelectByConditionSingle() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 封装对象
        Brand brand1 = new Brand();
        // brand1.setStatus(status);
        // brand1.setCompanyName(companyName);
        // brand1.setBrandName(brandName);

        // 1. 获取SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        List<Brand> brands = mapper.selectByConditionSingle(brand1);

        for (Brand brand : brands) {
            System.out.println(brand);
        }

        // 5. 关闭资源
        sqlSession.close();
    }

    /**
     * @description 增加
     */
    @Test
    public void testAdd() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "菠萝手机";
        String brandName = "菠萝";
        String description = "好手机，就用菠萝手机！！！";
        int ordered = 100;

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        // 1. 获取SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 2. 获取SqlSession对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.add(brand);

        // 提交事务
        // sqlSession.commit();

        // 5. 关闭资源
        sqlSession.close();
    }

    /**
     * @description 增加，获取主键返回值
     */
    @Test
    public void testAdd2() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "菠萝手机";
        String brandName = "菠萝";
        String description = "好手机，就用菠萝手机！！！";
        int ordered = 100;

        // 封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        // 1. 获取SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 2. 获取SqlSession对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

        // 提交事务
        // sqlSession.commit();

        // 5. 关闭资源
        sqlSession.close();
    }

    /**
     * @description 修改全部字段
     */
    @Test
    public void testUpdate() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "vivo手机";
        String brandName = "步步高";
        String description = "满分旗舰，vivoX100，只为你而生！！！";
        int ordered = 2000;

        int id = 8;

        // 封装对象
        Brand brand = new Brand();
        brand.setId(id);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        // brand.setDescription(description);
        // brand.setOrdered(ordered);

        // 1. 获取SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 2. 获取SqlSession对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        int count = brandMapper.update(brand);
        System.out.println(count);

        // 提交事务
        // sqlSession.commit();

        // 5. 关闭资源
        sqlSession.close();
    }


    /**
     * @description 根据Id删除一条品牌信息
     */
    @Test
    public void testDeleteById() throws IOException {
        // 接收参数
        int id = 8;

        // 1. 获取SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 2. 获取SqlSession对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.deleteById(id);

        // 提交事务
        // sqlSession.commit();

        // 5. 关闭资源
        sqlSession.close();
    }


    /**
     * @description 根据多个Id删除品牌信息
     */
    @Test
    public void testDeleteByIds() throws IOException {
        // 接收参数
        Integer[] ids = {6, 7};

        // 1. 获取SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 2. 获取SqlSession对象
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.deleteByIds(ids);

        // 提交事务
        // sqlSession.commit();

        // 5. 关闭资源
        sqlSession.close();
    }
}
