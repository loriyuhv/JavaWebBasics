package com.wsw.mapper;

import com.wsw.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;

/**
 * @author loriyuhv
 * @ClassName UserMapper
 * @date 2024/4/24 23:31
 * @description TODO
 */

public interface UserMapper {

    @Select("select * from tb_user where id = #{id};;")
    User selectById(Integer id);

    @Select("select * from tb_user;")
    List<User> selectAll();

    /**
     * @description MyBatis参数封装
     * 单个参数：
     *      1. POJO类型：直接使用，属性名和参数占位符名称一致
     *      2. Map集合：直接使用，键名 和 参数占位符名称一致
     *      3. Collection：封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
     *          map.put("arg0", collection集合)
     *          map.put("collection", collection集合)
     *      4. List：封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
     *          map.put("arg0", list集合)
     *          map.put("collection", list集合)
     *          map.put("list", list集合)
     *      5. Array：封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
     *          map.put("arg0", 数组)
     *          map.put("array", 数组)
     *      6. 其他类型
     * 多个参数：封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
     *  map.put("arg0", 参数值1);
     *  map.put("param1", 参数值1);
     *  map.put("arg1", 参数值2);
     *  map.put("param2", 参数值2);
     *  ---------@Param("username");
     *  map.put("username", 参数值1);
     *  map.put("param1", 参数值1);
     *  map.put("arg1", 参数值2);
     *  map.put("param2", 参数值2);
     *
     */
    // User select(@Param("username") String username, @Param("password") String password);
    User select(Collection collection);
    // User select(String username, String password);
}
