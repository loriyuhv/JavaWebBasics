package com.wsw.exercise02;

/**
 * @author loriyuhv
 * @ClassName Main
 * @date 2024/4/25 16:28
 * @description TODO
 */

public class Main {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance);
    }
}
