package com.wsw.a_simple;

import com.wsw.a_simple.car.Car;
import com.wsw.a_simple.car.impl.Audi;
import com.wsw.a_simple.car.impl.BMW;
import com.wsw.a_simple.car.impl.Benz;

/**
 * @author loriyuhv
 * @ClassName SimpleFactory
 * @date 2024/4/25 18:33
 * @description 简单工厂模式
 * 简单工厂模式
 * 定义：创建任务简单，一个工厂干所有的活。
 * 优点：逻辑简单。封装了创建逻辑，将创建和使用解耦。
 * 缺点：维护成本高，需要不断修改工厂内部实现，不符合开闭原则。
 */

public class SimpleFactory {

    /**
     * @description 工厂方法获取对应汽车 。。。
     */
    public static Car giveMeACar(String brandName) {
        if ("BMW".equals(brandName)) {
            return new BMW();
        }
        if ("Audi".equals(brandName)) {
            return new Audi();
        }
        if ("Benz".equals(brandName)) {
            return new Benz();
        }
        return null;
    }
}
