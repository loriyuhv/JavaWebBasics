package com.wsw.c_abstract_factory.carB.impl;

import com.wsw.c_abstract_factory.carB.BClassCar;

/**
 * @author loriyuhv
 * @ClassName BMW5
 * @date 2024/4/25 19:17
 * @description TODO
 */

public class BMW5 implements BClassCar {
    @Override
    public void showClassB() {
        System.out.println("这是一辆BMW5系汽车，是一辆B级车。");
    }
}
