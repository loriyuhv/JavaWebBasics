package com.wsw.mapper;

import com.wsw.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author loriyuhv
 * @ClassName BrandMapper
 * @date 2024/4/25 11:00
 * @description 品牌信息表mapper代理对象
 */

public interface BrandMapper {
    /**
     * @description 查看详情：通过id查询一条商品详情信息
     */
    Brand selectById(Integer id);

    /**
     * @description 查询商品订单数量小于等于50的商品信息
     */
    List<Brand> selectByConditionalOrdered(Integer Ordered);

    /**
     * @description 多条件查询——静态查询
     */
    // 方式一：默认
    // List<Brand> selectByCondition(Integer status, String companyName, String brandName);
    // 方式二：@Param
    // List<Brand> selectByCondition(@Param("status") Integer status, @Param("companyName") String companyName, @Param("brandName") String brandName);
    // 方式三：实体对象
    // List<Brand> selectByCondition(Brand brand);
    // 方式四：map
    List<Brand> selectByCondition(HashMap<Object, Object> map);

    /**
     * @description 多条件查询——动态查询：动态SQL
     */
    List<Brand> selectByConditionDynamic(Brand brand);
    
    /** 
     * @description 单条件查询——动态SQL
     */
    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * @description 添加数据
     */
    Integer add(Brand brand);

    /**
     * @description 添加数据，主键返回
     */
    Integer addOrder(Brand brand);

    /**
     * @description 修改信息
     */
    void update(Brand brand);

    /**
     * @description 删除一行数据
     */
    void deleteById(Integer id);

    /**
     * @description 批量删除数据
     */
    void deleteByIds(@Param("ids") Integer[] ids);
}
