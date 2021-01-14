package com.japhy.design;

/**
 * @author Japhy
 * @since 2020/11/12 11:31
 */
public class ElfKingdomFactory implements KingdomFactory{

    @Override
    public King createKing() {
        return new ElfKing();
    }

    @Override
    public Castle createCastle() {
        return new ElfCastle();
    }

    @Override
    public Army createArmy() {
        return new ElfArmy();
    }
}
