package com.wsw.c_abstract_factory.carC.impl;

import com.wsw.c_abstract_factory.carC.CClassCar;

/**
 * @author loriyuhv
 * @ClassName BenzC
 * @date 2024/4/25 19:16
 * @description TODO
 */

public class BenzC implements CClassCar {
    @Override
    public void showClassC() {
        System.out.println("这是一辆奔驰C系列汽车，是一辆C级车。");
    }
}
