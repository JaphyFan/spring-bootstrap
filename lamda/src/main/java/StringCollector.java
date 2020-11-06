import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author Japhy
 * @since 2020/4/25 16:23
 */
public class StringCollector implements Collector<String, StringCombiner, String> {

    private String prefix;

    private String delim;

    private String sufix;

    public StringCollector(String prefix, String delim, String sufix) {
        this.prefix = prefix;
        this.delim = delim;
        this.sufix = sufix;
    }

    @Override
    public Supplier<StringCombiner> supplier() {
        return () -> new StringCombiner(prefix, delim, sufix);
    }

    @Override
    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }

    @Override
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }

    @Override
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        HashSet<Characteristics> objects = new HashSet<>();
        objects.add(Characteristics.UNORDERED);
        return objects;
    }
}
