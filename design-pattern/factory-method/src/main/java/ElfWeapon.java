/**
 * @author Japhy
 * @since 2020/11/11 16:23
 */
public class ElfWeapon implements Weapon {

    private final WeaponType weaponType;

    public ElfWeapon(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    @Override
    public String toString() {
        return "ElfWeapon{" +
            "weaponType=" + weaponType +
            '}';
    }
}
