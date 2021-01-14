/**
 * @author Japhy
 * @since 2020/11/11 16:20
 */
public enum WeaponType {

    AXE("axe"), SWORD("sword"),
    ;

    private final String desc;

    WeaponType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "WeaponType{" +
            "desc='" + desc + '\'' +
            '}';
    }
}
