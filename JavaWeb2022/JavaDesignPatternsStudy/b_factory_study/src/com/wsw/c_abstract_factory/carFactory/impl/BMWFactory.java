package com.wsw.c_abstract_factory.carFactory.impl;

import com.wsw.c_abstract_factory.carB.BClassCar;
import com.wsw.c_abstract_factory.carB.impl.BMW5;
import com.wsw.c_abstract_factory.carC.CClassCar;
import com.wsw.c_abstract_factory.carC.impl.BMW3;
import com.wsw.c_abstract_factory.carFactory.AbstractCarFactory;

/**
 * @author loriyuhv
 * @ClassName BMWFactory
 * @date 2024/4/25 19:13
 * @description TODO
 */

public class BMWFactory implements AbstractCarFactory {
    @Override
    public BClassCar build_B_ClassCar() {
        System.out.println("宝马车厂生产B级车。");
        return new BMW5();
    }

    @Override
    public CClassCar build_C_ClassCar() {
        System.out.println("宝马车厂生产C级车。");
        return new BMW3();
    }
}
