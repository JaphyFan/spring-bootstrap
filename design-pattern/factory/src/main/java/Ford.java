
/**
 * @author Japhy
 * @since 2020/11/6 13:45
 */
public class Ford implements Car{

    @Override
    public String getDescription() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Ford";
    }
}
