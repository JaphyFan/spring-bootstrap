package com.japhy.design.t2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Japhy
 * @since 2020/11/5 15:00
 */
@FunctionalInterface
public interface WeaponFactory {

    Weapon create(WeaponType weaponType);

    static WeaponFactory factory(Consumer<Builder> consumer) {
        Map<WeaponType, Supplier<Weapon>> map = new HashMap<>();
        consumer.accept((WeaponType key, Supplier<Weapon> value) -> map.put(key, value));
        return weaponType -> map.get(weaponType).get();
    }

}
