package com.wsw.c_abstract_factory;

import com.wsw.b_factory_method.car.Car;
import com.wsw.c_abstract_factory.carB.BClassCar;
import com.wsw.c_abstract_factory.carFactory.impl.BMWFactory;

/**
 * @author loriyuhv
 * @ClassName FactoryTest
 * @date 2024/4/25 19:26
 * @description TODO
 */

public class FactoryTest {
    public static void main(String[] args) {
        // 生产宝马B级车，奔驰C级车，只需要知道对应工厂即可。

        // 生产宝马B级车
        BClassCar bClassCar = new BMWFactory().build_B_ClassCar();
        bClassCar.showClassB();
    }
}
