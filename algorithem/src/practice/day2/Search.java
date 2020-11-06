package day2;

/**
 * @author Japhy
 * @since 2020/6/12 09:56
 */
public interface Search {

    <T extends Comparable<T>> int find(T[] arr, T key);
}
