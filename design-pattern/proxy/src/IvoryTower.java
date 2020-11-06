/**
 * @author Japhy
 * @since 2020/9/15 18:47
 */
public class IvoryTower implements WizardTower {

    @Override
    public void enter(Wizard wizard) {
        System.out.println(wizard.getName() + "enter the " + this.getClass().getCanonicalName());
    }
}
