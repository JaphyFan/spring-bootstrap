package com.japhy.design;

/**
 * @author Japhy
 * @since 2020/11/12 11:31
 */
public class OrcKingdomFactory implements KingdomFactory{

    @Override
    public King createKing() {
        return new OrcKing();
    }

    @Override
    public Castle createCastle() {
        return new OrcCastle();
    }

    @Override
    public Army createArmy() {
        return new OrcArmy();
    }
}
