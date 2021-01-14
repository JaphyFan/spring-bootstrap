package com.japhy.design;

/**
 * @author Japhy
 * @since 2020/11/12 11:26
 */
public class Kingdom {

    private King king;

    private Castle castle;

    private Army army;

    public static KingdomFactory factory(KingdomType kingdomType) {
        switch (kingdomType) {
            case ELF:
                return new ElfKingdomFactory();
            case ORC:
                return new OrcKingdomFactory();
            default:
                throw new IllegalArgumentException();
        }
    }
}
