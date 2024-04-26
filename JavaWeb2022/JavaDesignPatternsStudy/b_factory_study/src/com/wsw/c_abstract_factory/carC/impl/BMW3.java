package com.wsw.c_abstract_factory.carC.impl;

import com.wsw.c_abstract_factory.carC.CClassCar;

/**
 * @author loriyuhv
 * @ClassName BMW3
 * @date 2024/4/25 19:14
 * @description TODO
 */

public class BMW3 implements CClassCar {
    @Override
    public void showClassC() {
        System.out.println("这是一辆宝马C系列汽车，是一辆C级车。");
    }
}
