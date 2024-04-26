package com.wsw.b_factory_method.factory.impl;

import com.wsw.b_factory_method.car.Car;
import com.wsw.b_factory_method.car.impl.Benz;
import com.wsw.b_factory_method.factory.CarFactory;

/**
 * @author loriyuhv
 * @ClassName BenzFactory
 * @date 2024/4/25 18:52
 * @description TODO
 */

public class BenzFactory implements CarFactory {
    @Override
    public Car buildACar() {
        System.out.println("这里是奔驰工厂，我们只生产奔驰汽车。");
        return new Benz();
    }
}
