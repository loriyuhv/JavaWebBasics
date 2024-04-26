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

/**
 * @author loriyuhv
 * @ClassName BrandMapperTest
 * @date 2024/4/25 11:20
 * @description 针对BrandMapper SQL映射文件测试
 */

public class BrandMapperTest {

    /**
     * @description 测试：查看详情：通过id查询一条商品详情信息
     */
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

    /**
     * @description 测试：查询商品订单数量小于等于50的商品信息
     */
    @Test
    public void testSelectByConditionalOrdered() throws IOException {
        // 接收的参数
        Integer ordered = 50;

        // 1. 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行sql方法
        List<Brand> brands = brandMapper.selectByConditionalOrdered(ordered);
        for (Brand brand : brands) {
            System.out.println(brand);
        }

        // 5. 释放资源
        sqlSession.close();
    }

    /**
     * @description 测试：多条件查询——静态查询
     */
    @Test
    public void testSelectByCondition() throws IOException {
        // 接收参数
        Integer status = 1;
        String brandName = "华为";
        String companyName = "华为";

        // 处理参数
        brandName = "%" + brandName + "%";
        companyName = "%" + companyName + "%";

        // 1. 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行sql方法
        // 方式一和方式二
        // List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        // for (Brand brand : brands) {
        //     System.out.println(brand);
        // }

        // 方式三 实体对象
        // Brand brand = new Brand();
        // brand.setCompanyName(companyName);
        // brand.setBrandName(brandName);
        // brand.setStatus(status);
        // List<Brand> brands = brandMapper.selectByCondition(brand);
        // for (Brand brand1 : brands) {
        //     System.out.println(brand1);
        // }

        // 方式四
        HashMap<Object, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);
        List<Brand> brands = brandMapper.selectByCondition(map);
        for (Brand brand : brands) {
            System.out.println(brand);
        }

        // 5. 释放资源
        sqlSession.close();
    }

    /**
     * @description 测试：多条件查询——动态查询
     */
    @Test
    public void testSelectByConditionDynamic() throws IOException {
        // 接收参数
        Integer status = 1;
        String brandName = "华为";
        String companyName = "华为";

        // 处理参数
        brandName = "%" + brandName + "%";
        companyName = "%" + companyName + "%";

        // 1. 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行sql方法
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        // brand.setStatus(status);
        List<Brand> brands = brandMapper.selectByConditionDynamic(brand);
        for (Brand brand1 : brands) {
            System.out.println(brand1);
        }

        // 5. 释放资源
        sqlSession.close();
    }

    /**
     * @description 单条件查询——动态SQL
     */
    @Test
    public void testSelectByConditionSingle() throws IOException {
        // 接收参数
        Integer status = 1;
        String brandName = "华为";
        String companyName = "华为";

        // 处理参数
        brandName = "%" + brandName + "%";
        companyName = "%" + companyName + "%";

        // 1. 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行sql方法
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setStatus(status);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        for (Brand brand1 : brands) {
            System.out.println(brand1);
        }

        // 5. 释放资源
        sqlSession.close();
    }

    /**
     * @description 添加数据
     */
    @Test
    public void testAdd() throws IOException {
        // 接收参数
        // String brandName = "OPPO";
        // String companyName = "OPPO技术有限公司";
        // Integer ordered = 200;
        // String description = "充电5分钟，通话2小时";
        // Integer status = 1;

        String brandName = "波导";
        String companyName = "波导技术有限公司";
        Integer ordered = 100;
        String description = "波导手机，手机中的战斗机";
        Integer status = 1;

        // 1. 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 2. 获取SqlSession对象
        // Setting autocommit to false on JDBC Connection 表示事务自动提交为关闭
        // true:设置事务为自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行sql方法
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setStatus(status);

        Integer add = brandMapper.add(brand);
        // sqlSession.commit();   // 手动提交事务
        if (add > 0) {
            System.out.println("添加信息成功！");
        } else {
            System.out.println("添加信息失败！");
        }

        // 5. 释放资源
        sqlSession.close();
    }

    /**
     * @description 添加数据，主键返回
     */
    @Test
    public void testAddOrder() throws IOException {
        // 接收参数
        String brandName = "金立";
        String companyName = "金立技术有限公司";
        Integer ordered = 125;
        String description = "金品质、立天下";
        Integer status = 1;

        // 1. 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 2. 获取SqlSession对象
        // Setting autocommit to false on JDBC Connection 表示事务自动提交为关闭
        // true:设置事务为自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行sql方法
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setStatus(status);

        Integer add = brandMapper.addOrder(brand);
        // sqlSession.commit();   // 手动提交事务
        if (add > 0) {
            System.out.println("添加信息成功！");
            System.out.println("主键Id：" + brand.getId());
        } else {
            System.out.println("添加信息失败！");
        }

        // 5. 释放资源
        sqlSession.close();
    }

    /**
     * @description 更新数据
     */
    @Test
    public void testUpdate() throws IOException {
        // 接收参数
        Integer id = 12;
        String brandName = "三星";
        String companyName = "三星科技技术有限公司";
        Integer ordered = 100;
        String description = "点亮你的生活，就要轻薄你!";
        Integer status = 1;

        // 1. 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 2. 获取SqlSession对象
        // Setting autocommit to false on JDBC Connection 表示事务自动提交为关闭
        // true:设置事务为自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行sql方法
        Brand brand = new Brand();
        brand.setId(id);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        // brand.setStatus(status);

        brandMapper.update(brand);

        // 5. 释放资源
        sqlSession.close();
    }

    /**
     * @description 删除一行数据
     */
    @Test
    public void testDeleteById() throws IOException {
        // 接收参数
        Integer id = 14;

        // 1. 获取SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行sql方法
        brandMapper.deleteById(id);
        // 5. 释放资源
        sqlSession.close();
    }

    /**
     * @description 根据id批量删除数据
     */
    @Test
    public void testDeleteByIds() throws IOException {
        // 接收参数
        Integer[] ids = {16, 17, 18};

        // 1. 获取SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行sql方法
        brandMapper.deleteByIds(ids);
        // 5. 释放资源
        sqlSession.close();
    }


    /**
     * @description 根据id批量删除数据
     */
    @Test
    public void test() throws IOException {
        // 1. 获取SqlSessionFactory对象
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);


        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. 获取Mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 5. 释放资源
        sqlSession.close();
    }
}
