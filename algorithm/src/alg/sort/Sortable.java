package alg.sort;

/**
 * @author Japhy
 * @since 2022/4/27 17:18
 */
public interface Sortable {

    void sort(int[] a);

    void show(int[] a);

    boolean less(int i, int j);

    void exch(int[] a, int i, int j);

}
