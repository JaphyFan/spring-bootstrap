package alg.graph;

/**
 * @author Japhy
 * @since 2022/5/17 19:51
 */
public interface Paths {

    boolean hasPathTo(int v);

    Iterable<Integer> pathTo(int v);

}
