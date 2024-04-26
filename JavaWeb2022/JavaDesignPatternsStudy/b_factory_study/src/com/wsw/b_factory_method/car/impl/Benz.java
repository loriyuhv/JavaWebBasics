package com.wsw.b_factory_method.car.impl;

import com.wsw.b_factory_method.car.Car;

/**
 * @author loriyuhv
 * @ClassName Benz
 * @date 2024/4/25 18:34
 * @description TODO
 */

public class Benz implements Car {
    @Override
    public void showTheBrand() {
        System.out.println("这是一辆“奔驰”汽车。");
    }
}
