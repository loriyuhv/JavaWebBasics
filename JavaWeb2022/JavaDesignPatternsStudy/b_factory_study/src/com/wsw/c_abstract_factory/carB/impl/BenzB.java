package com.wsw.c_abstract_factory.carB.impl;

import com.wsw.c_abstract_factory.carB.BClassCar;

/**
 * @author loriyuhv
 * @ClassName BenzB
 * @date 2024/4/25 19:14
 * @description TODO
 */

public class BenzB implements BClassCar {
    @Override
    public void showClassB() {
        System.out.println("这是一辆奔驰B系列汽车，是一辆B级车。");
    }
}
