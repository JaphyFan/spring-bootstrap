package com.japhy.design;

/**
 * @author Japhy
 * @since 2020/11/12 11:28
 */
public interface KingdomFactory {

    King createKing();

    Castle createCastle();

    Army createArmy();
}
