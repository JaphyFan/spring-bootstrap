package com.japhy.design.prototype;

import java.util.Objects;

/**
 * @author Japhy
 * @since 2020/11/16 15:11
 */
public class OrcBeast extends Beast {

    private String weapon;

    public OrcBeast(OrcBeast beast) {
        super(beast);
        this.weapon = beast.weapon;
    }

    public OrcBeast(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public OrcBeast copy() {
        return new OrcBeast(this);
    }

    @Override
    public String toString() {
        return "com.japhy.design.prototype.OrcBeast{" +
            "weapon='" + weapon + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrcBeast orcBeast = (OrcBeast) o;
        return Objects.equals(weapon, orcBeast.weapon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weapon);
    }
}
