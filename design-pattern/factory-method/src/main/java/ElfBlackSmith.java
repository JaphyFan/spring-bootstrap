import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Japhy
 * @since 2020/11/11 16:27
 */
public class ElfBlackSmith implements BlackSmith {

    private static Map<WeaponType, Weapon> ELFARSENAL;

    static {
        ELFARSENAL = new HashMap<>();
        Arrays.stream(WeaponType.values())
            .forEach(weaponType -> ELFARSENAL.put(weaponType, new ElfWeapon(weaponType)));
    }

    @Override
    public Weapon manufacture(WeaponType weaponType) {
        return ELFARSENAL.get(weaponType);
    }
}
