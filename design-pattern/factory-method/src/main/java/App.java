/**
 * @author Japhy
 * @since 2020/11/11 16:28
 */
public class App {

    private final BlackSmith blackSmith;

    public App(BlackSmith blackSmith) {
        this.blackSmith = blackSmith;
    }

    public static void main(String[] args) {
        App app = new App(new OrcBlackSmith());
        Weapon orcWeapon = app.blackSmith.manufacture(WeaponType.AXE);
        System.out.println(orcWeapon);

        App app1 = new App(new ElfBlackSmith());
        Weapon elfWeapon = app1.blackSmith.manufacture(WeaponType.SWORD);
        System.out.println(elfWeapon);
    }
}
