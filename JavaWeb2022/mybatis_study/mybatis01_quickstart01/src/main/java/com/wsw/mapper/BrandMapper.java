package com.wsw.mapper;

import com.wsw.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author loriyuhv
 * @ClassName BandMapper
 * @date 2024/4/24 19:59
 * @description TODO
 */

public interface BrandMapper {
    // 查询所有
    List<Brand> selectAll();

    // 查看详情，根据Id查询
    Brand selectByIdBrand(int id);

    /**
     * @description 条件查询
     * 参数接收
     *  1. 散装参数：如果方法中有多个参数，需要使用@Param("SQL参数占位符");
     *  2. 对象参数：对象的属性名称要和参数占位符一致
     *  3. map集合参数
     */
    // List<Brand> selectByCondition(@Param("status") int status,
    //                               @Param("companyName") String companyName,
    //                               @Param("brandName") String brandName);
    // List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);

    /**
     * @description 单条件动态查询
     */
    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * @description 添加
     */
    void add(Brand brand);

    /**
     * @description 修改全部字段
     */
    int update(Brand brand);

    /**
     * @description 根据Id删除
     */
    void deleteById(Integer id);

    /**
     * @description 根据Id删除 批量删除
     */
    void deleteByIds(@Param("ids") Integer[] ids);

}
