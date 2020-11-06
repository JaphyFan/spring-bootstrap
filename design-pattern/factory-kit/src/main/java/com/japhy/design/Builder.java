package com.japhy.design;

import java.util.function.Supplier;

/**
 * lamda 接口
 * @author Japhy
 * @since 2020/6/10 18:50
 */
public interface Builder {

    void add(WeaponType name, Supplier<Weapon> supplier);

}
