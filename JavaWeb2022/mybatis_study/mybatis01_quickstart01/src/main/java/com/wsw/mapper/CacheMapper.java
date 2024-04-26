package com.wsw.mapper;

import com.wsw.pojo.Brand;

/**
 * @author loriyuhv
 * @ClassName CacheMapper
 * @date 2024/4/25 19:44
 * @description 缓存Mapper
 */

public interface CacheMapper {
    Brand getBrandById(Integer id);

    Brand getBrandByName(String brandName);

    Integer add(Brand brand);
}
