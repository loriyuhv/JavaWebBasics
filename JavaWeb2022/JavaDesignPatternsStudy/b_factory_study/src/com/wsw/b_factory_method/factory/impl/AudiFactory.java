package com.wsw.b_factory_method.factory.impl;

import com.wsw.b_factory_method.car.Car;
import com.wsw.b_factory_method.car.impl.Audi;
import com.wsw.b_factory_method.factory.CarFactory;

/**
 * @author loriyuhv
 * @ClassName AudiFactory
 * @date 2024/4/25 18:51
 * @description TODO
 */

public class AudiFactory implements CarFactory {
    @Override
    public Car buildACar() {
        System.out.println("这里是奥迪工厂，这里只生产奥迪汽车。");
        return new Audi();
    }
}
