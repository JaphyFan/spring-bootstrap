/**
 * @author Japhy
 * @since 2020/11/11 16:21
 */
public class OrcWeapon implements Weapon {

    private final WeaponType weaponType;

    public OrcWeapon(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public WeaponType getWeaponType() {
        return weaponType;
    }

    @Override
    public String toString() {
        return "OrcWeapon{" +
            "weaponType=" + weaponType +
            '}';
    }
}
