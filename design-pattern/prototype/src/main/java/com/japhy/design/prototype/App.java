package com.japhy.design.prototype;

/**
 * @author Japhy
 * @since 2020/11/16 15:13
 */
public class App {

    public static void main(String[] args) {

        HeroFacotry facotry = new HeroFacotry(new OrcBeast("axe"));
        System.out.println(facotry.newBeast());
    }


}
