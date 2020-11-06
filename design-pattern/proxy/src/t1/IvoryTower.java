package t1;

/**
 * @author Japhy
 * @since 2020/11/5 16:03
 */
public class IvoryTower implements WizardTower {

    @Override
    public void enter(Wizard wizard) {
        System.out.println(wizard + " entered");
    }
}
