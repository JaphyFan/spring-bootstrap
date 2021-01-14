
/**
 * @author Japhy
 * @since 2020/11/6 13:55
 */
public class Ferrari implements Car{

    @Override
    public String getDescription() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Ferrari";
    }
}
