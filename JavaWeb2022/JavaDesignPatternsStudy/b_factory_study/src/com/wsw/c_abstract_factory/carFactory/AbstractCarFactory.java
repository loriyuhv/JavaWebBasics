package com.wsw.c_abstract_factory.carFactory;

import com.wsw.c_abstract_factory.carB.BClassCar;
import com.wsw.c_abstract_factory.carC.CClassCar;

/**
 * @author loriyuhv
 * @ClassName AbstractCarFactory
 * @date 2024/4/25 19:13
 * @description TODO
 */

public interface AbstractCarFactory {
    BClassCar build_B_ClassCar();
    CClassCar build_C_ClassCar();
}
