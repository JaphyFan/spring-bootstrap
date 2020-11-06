/**
 * @author Japhy
 * @since 2020/9/15 18:49
 */
public class WizardTowerProxy implements WizardTower {

    private int num;

    private final WizardTower wizardTower;

    public WizardTowerProxy(WizardTower wizardTower) {
        this.wizardTower = wizardTower;
    }

    @Override
    public void enter(Wizard wizard) {
        if (num >= 2) {
            System.out.println(wizard.getName() + "cant enter the tower");
        } else {
            num++;
            wizardTower.enter(wizard);
        }
    }
}
