package com.wsw.mapper;

import com.wsw.pojo.Brand;

/**
 * @author loriyuhv
 * @ClassName BrandMapper
 * @date 2024/4/25 11:00
 * @description 品牌信息表mapper代理对象
 */

public interface BrandMapper {
    /**
     * @description 通过id查询一条商品信息
     */
    Brand selectById(Integer id);
}
