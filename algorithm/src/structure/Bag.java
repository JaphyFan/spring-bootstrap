package structure;

/**
 *
 * 不支持删除
 * @author Japhy
 * @since 2022/3/3 15:48
 */
public interface Bag<T> extends Iterable<T> {

    void add(T t);

    boolean isEmpty();

    int size();
}
