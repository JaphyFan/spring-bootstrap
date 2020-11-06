package t1;

/**
 * @author Japhy
 * @since 2020/11/5 16:02
 */
public class Wizard {

    private String name;

    public Wizard(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Wizard{" +
            "name='" + name + '\'' +
            '}';
    }
}
