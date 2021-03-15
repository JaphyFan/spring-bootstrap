package com.japhy.desgin.flyweight;

/**
 * @author Japhy
 * @since 2021/2/24 19:45
 */
public class App {

    public static void main(String[] args) {
        PortionFactory portionFactory = new PortionFactory();
        Portion portion = portionFactory.createPortion(PortionType.HEALING);
        System.out.println(portion);
        Portion portion2 = portionFactory.createPortion(PortionType.HEALING);
        System.out.println(portion2);
    }

}
