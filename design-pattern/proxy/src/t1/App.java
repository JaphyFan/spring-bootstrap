package t1;

/**
 * @author Japhy
 * @since 2020/11/5 16:07
 */
public class App {

    public static void main(String[] args) {
        WizardTower tower = new IvoryTower();
        WizardTowerProxy proxy = new WizardTowerProxy(tower);

        Wizard wizard = new Wizard("1");
        Wizard wizard2 = new Wizard("2");
        Wizard wizard3 = new Wizard("3");
        Wizard wizard4 = new Wizard("4");
        proxy.enter(wizard);
        proxy.enter(wizard2);
        proxy.enter(wizard3);
        proxy.enter(wizard4);
    }

}
