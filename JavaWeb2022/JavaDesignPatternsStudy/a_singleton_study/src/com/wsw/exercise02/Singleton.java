package com.wsw.exercise02;

/**
 * @author loriyuhv
 * @ClassName Singleton
 * @date 2024/4/25 16:26
 * @description TODO
 */

public class Singleton {
    private final static Singleton singleton = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return singleton;
    }
}
