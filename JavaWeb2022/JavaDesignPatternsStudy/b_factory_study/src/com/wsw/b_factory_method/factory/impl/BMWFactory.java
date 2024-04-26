package com.wsw.b_factory_method.factory.impl;

import com.wsw.b_factory_method.car.Car;
import com.wsw.b_factory_method.car.impl.BMW;
import com.wsw.b_factory_method.factory.CarFactory;

/**
 * @author loriyuhv
 * @ClassName BMWFactory
 * @date 2024/4/25 18:50
 * @description TODO
 */

public class BMWFactory implements CarFactory {
    @Override
    public Car buildACar() {
        System.out.println("这里是宝马工厂，我们只生产宝马汽车。");
        return new BMW();
    }
}
