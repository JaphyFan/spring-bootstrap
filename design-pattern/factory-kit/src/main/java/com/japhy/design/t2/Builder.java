package com.japhy.design.t2;

import java.util.function.Supplier;

/**
 * @author Japhy
 * @since 2020/11/5 15:01
 */
public interface Builder {

    void add(WeaponType weaponType, Supplier<Weapon> supplier);
}
