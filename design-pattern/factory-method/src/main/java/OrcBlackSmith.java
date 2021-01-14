import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Japhy
 * @since 2020/11/11 16:24
 */
public class OrcBlackSmith implements BlackSmith{

    private static Map<WeaponType, Weapon> ORCARSENAL;

    static {
        ORCARSENAL = new HashMap<>();
        Arrays.stream(WeaponType.values())
            .forEach(weaponType -> ORCARSENAL.put(weaponType, new OrcWeapon(weaponType)));
    }

    @Override
    public Weapon manufacture(WeaponType weaponType) {
        return ORCARSENAL.get(weaponType);
    }
}
