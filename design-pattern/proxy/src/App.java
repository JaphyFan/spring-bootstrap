/**
 * @author Japhy
 * @since 2020/9/15 18:51
 */
public class App {

    public static void main(String[] args) {
        Wizard wizard1 = new Wizard();
        wizard1.setName("fanjh");

        Wizard wizard2 = new Wizard();
        wizard2.setName("zyh");

        Wizard wizard3 = new Wizard();
        wizard3.setName("great");

        IvoryTower ivoryTower = new IvoryTower();
        WizardTowerProxy wizardTowerProxy = new WizardTowerProxy(ivoryTower);
        wizardTowerProxy.enter(wizard1);
        wizardTowerProxy.enter(wizard2);
        wizardTowerProxy.enter(wizard3);
    }
}
