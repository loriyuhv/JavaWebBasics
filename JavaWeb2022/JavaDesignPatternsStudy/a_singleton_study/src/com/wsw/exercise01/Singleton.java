package com.wsw.exercise01;

/**
 * @author loriyuhv
 * @ClassName Singleton
 * @date 2024/4/25 16:14
 * @description
 * Singleton类只会生成一个实例。
 * Singleton类定义了static字段（类的成员变量）singleton，并将其初始化
 * 为Singleton类的实例。初始化行为仅在该类被加载时进行一次。
 * Singleton类的构造函数时private的，这是为了禁止从Singleton类外部调用
 * 构造函数。如果从Singleton类以外的代码中调用构造函数new Singleton(),
 * 就会出现编译错误。
 * 还准备了getInstance方法，以便于程序从Singleton类外部获取Singleton类
 * 唯一的实例。
 */

public class Singleton {
    private static final Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("生成了一个实例");
    }
    public static Singleton getInstance() {
        return singleton;
    }
}
