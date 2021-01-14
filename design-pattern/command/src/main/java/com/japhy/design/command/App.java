package com.japhy.design.command;

/**
 * @author Japhy
 * @since 2020/11/20 14:44
 */
public class App {

    public static void main(String[] args) {
        Goblin goblin = new Goblin();

        Wizard wizard = new Wizard();
        wizard.castSpell(goblin::changeVisibility);
        goblin.printStatus();

        wizard.undoSpell();
        goblin.printStatus();

        wizard.redoSpell();
        goblin.printStatus();
    }

}
