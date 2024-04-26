package com.wsw.a_simple;

import com.wsw.a_simple.car.Car;

import java.sql.DriverManager;

/**
 * @author loriyuhv
 * @ClassName SimpleTest
 * @date 2024/4/25 18:33
 * @description TODO
 */

public class SimpleTest {
    public static void main(String[] args) {

        Car myCar = SimpleFactory.giveMeACar("BMW");
        if (myCar != null) {
            myCar.showTheBrand();
        } else {
            System.out.println("暂时无法生产该车");
        }
    }
}
