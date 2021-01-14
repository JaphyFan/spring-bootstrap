
/**
 * @author Japhy
 * @since 2020/11/6 14:04
 */
public class App {

    public static void main(String[] args) {
        Car car = CarFactory.getCar(CarType.FORD);
        System.out.println(car.getDescription());
    }
}
