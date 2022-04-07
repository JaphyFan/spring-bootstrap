package structure;


/**
 * @author Japhy
 * @since 2022/3/3 15:55
 */
public interface Stack<T> extends Iterable<T> {

    void push(T item);

    T pop();

    int size();

    boolean isEmpty();
}
