package com.japhy.design.prototype;

/**
 * @author Japhy
 * @since 2020/11/16 15:12
 */
public class ElfBeast extends Beast{

    private String weapon;

    public ElfBeast(ElfBeast beast) {
        super(beast);
        this.weapon = beast.weapon;
    }

    @Override
    public ElfBeast copy() {
        return new ElfBeast(this);
    }

    @Override
    public String toString() {
        return "com.japhy.design.prototype.ElfBeast{" +
            "weapon='" + weapon + '\'' +
            '}';
    }
}
