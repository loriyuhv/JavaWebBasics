package com.wsw.study;

/**
 * @author loriyuhv
 * @ClassName Main
 * @date 2024/4/25 18:23
 * @description
 */

public class Main {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance2 == instance2);
    }
}
