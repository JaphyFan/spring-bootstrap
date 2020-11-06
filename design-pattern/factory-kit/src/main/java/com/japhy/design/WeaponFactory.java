package com.japhy.design;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Japhy
 * @since 2020/6/10 18:45
 */
public interface WeaponFactory {

    /**
     *
     * @param name
     * @return
     */
    Weapon create(WeaponType name);

    static WeaponFactory factory(Consumer<Builder> consumer) {
        var map = new HashMap<WeaponType, Supplier<Weapon>>();
        consumer.accept(map::put);
        return name -> map.get(name).get();
    }

}
