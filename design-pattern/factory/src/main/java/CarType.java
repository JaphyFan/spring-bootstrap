
import java.util.function.Supplier;

/**
 * @author Japhy
 * @since 2020/11/6 13:56
 */
public enum CarType {

    FORD(Ford::new),
    FERRARI(Ferrari::new),
    ;

    private final Supplier<Car> supplier;

    CarType(Supplier<Car> supplier) {
        this.supplier = supplier;
    }

    public Supplier<Car> getSupplier() {
        return supplier;
    }
}
