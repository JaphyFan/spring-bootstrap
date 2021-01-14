
/**
 * @author Japhy
 * @since 2020/11/6 13:57
 */
public class CarFactory {

    public static Car getCar(CarType carType) {
        return carType.getSupplier().get();
    }
}
