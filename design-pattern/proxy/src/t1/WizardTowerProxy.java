package t1;

/**
 * @author Japhy
 * @since 2020/11/5 16:04
 */
public class WizardTowerProxy implements WizardTower{

    private final static int NUM_WIZARDS_ALLOWED = 2;
    private int numWizards;

    private WizardTower wizardTower;

    public WizardTowerProxy(WizardTower wizardTower) {
        this.wizardTower = wizardTower;
    }

    @Override
    public void enter(Wizard wizard) {
        if (numWizards <= NUM_WIZARDS_ALLOWED) {
            wizardTower.enter(wizard);
            numWizards++;
        } else {
            System.out.println("WizardTower is fulled with " + numWizards);
        }
    }
}
