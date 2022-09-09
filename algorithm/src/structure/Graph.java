package structure;

/**
 * @author Japhy
 * @since 2022/5/16 20:09
 */
public interface Graph {

    int v();

    int e();

    void addEdge(int v, int w);

    Iterable<Integer> adj(int v);


}
