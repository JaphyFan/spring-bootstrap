package structure.demo;

/**
 * @author Japhy
 * @since 2022/4/25 17:42
 */
public interface UFAbstract {

    boolean connected(int p, int q);

    void union(int p, int q);

    int count();

    int find(int x);

    int[] getId();

}
