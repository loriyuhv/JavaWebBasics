package com.wsw.c_abstract_factory.carFactory.impl;

import com.wsw.c_abstract_factory.carB.BClassCar;
import com.wsw.c_abstract_factory.carB.impl.BenzB;
import com.wsw.c_abstract_factory.carC.CClassCar;
import com.wsw.c_abstract_factory.carC.impl.BenzC;
import com.wsw.c_abstract_factory.carFactory.AbstractCarFactory;

/**
 * @author loriyuhv
 * @ClassName BenzFactory
 * @date 2024/4/25 19:13
 * @description TODO
 */

public class BenzFactory implements AbstractCarFactory {
    @Override
    public BClassCar build_B_ClassCar() {
        System.out.println("奔驰车厂生产B级车。");
        return new BenzB();
    }

    @Override
    public CClassCar build_C_ClassCar() {
        System.out.println("奔驰车厂生产C级车。");
        return new BenzC();
    }
}
