package com.japhy.design.singleton;

/**
 * @author Japhy
 * @since 2020/11/9 13:28
 */
public class InitializingOndemandHolderIdiom {

    private InitializingOndemandHolderIdiom() {
    }

    public static InitializingOndemandHolderIdiom getInstance() {
        return HolderHelper.INSTACNE;
    }

    private static class HolderHelper {

        private static final InitializingOndemandHolderIdiom INSTACNE =
            new InitializingOndemandHolderIdiom();
    }

}
