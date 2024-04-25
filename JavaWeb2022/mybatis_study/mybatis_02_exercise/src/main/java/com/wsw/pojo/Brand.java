package com.wsw.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author loriyuhv
 * @ClassName Brand
 * @date 2024/4/25 11:03
 * @description Brand 品牌信息表实体类
 */

@Data
public class Brand {
    private Integer id;
    private String brandName;
    private String companyName;
    private Integer ordered;
    private String description;
    private Integer status;
}
