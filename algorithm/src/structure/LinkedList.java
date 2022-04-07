package structure;

/**
 * @author Japhy
 * @since 2022/3/4 23:06
 */
public interface LinkedList<T> {

    T getFirst();

    T getLast();

    T removeFirst();

    int size();

    boolean isEmpty();

    void addFirst(T t);

    void addLast(T t);

}
