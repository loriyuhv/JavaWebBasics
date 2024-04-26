package com.wsw.b_factory_method;

import com.wsw.b_factory_method.car.Car;
import com.wsw.b_factory_method.factory.CarFactory;
import com.wsw.b_factory_method.factory.impl.BMWFactory;

/**
 * @author loriyuhv
 * @ClassName FactoryTest
 * @date 2024/4/25 18:55
 * @description
 *
 * 工厂方法模式测试
 * 定义：简单工厂升级版。对工厂开始动刀子。定义工厂接口，制定规则，但具体
 * 实现下沉到实现体去控制。
 * 优点：相比简单工厂，利于扩展和维护。比如当新增一种车型时，只需要创建对应
 * 具体产品类和负责生产新品种车的具体工厂即可。符合“开闭原则”。便于扩展。
 * 缺点：具有一定的局限性，只能生产一种产品（由接口内部方法决定），比如我要
 * 生成BMW牌子的某级别车就不直接支持。
 */

public class FactoryTest {
    public static void main(String[] args) {
        // 只需要知道哪个工厂生产宝马车，不需要知道宝马车类别是什么。
        // 比如我想要宝马车，我知道宝马厂生产宝马车。
        CarFactory carFactory = new BMWFactory();
        Car car = carFactory.buildACar();
        car.showTheBrand();
    }
}
