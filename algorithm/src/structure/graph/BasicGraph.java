package structure.graph;

import structure.Bag;
import structure.Graph;
import structure.LinkedBag;

/**
 * @author Japhy
 * @since 2022/5/17 16:24
 */
public class BasicGraph implements Graph {

    private int v;

    private int e;

    private Bag<Integer>[] adj;

    public BasicGraph(int v) {
        this.v = v;
        this.e = 0;
        adj = new LinkedBag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedBag<>();
        }
    }

    @Override
    public int v() {
        return v;
    }

    @Override
    public int e() {
        return e;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        e++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
