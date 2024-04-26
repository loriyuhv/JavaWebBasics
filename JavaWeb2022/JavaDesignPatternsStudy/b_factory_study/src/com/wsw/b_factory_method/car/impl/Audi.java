package com.wsw.b_factory_method.car.impl;

import com.wsw.b_factory_method.car.Car;

/**
 * @author loriyuhv
 * @ClassName Audi
 * @date 2024/4/25 18:33
 * @description TODO
 */

public class Audi implements Car {
    @Override
    public void showTheBrand() {
        System.out.println("这是一辆“奥迪”汽车。");
    }
}
