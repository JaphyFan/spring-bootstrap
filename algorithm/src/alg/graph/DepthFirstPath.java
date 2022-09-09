package alg.graph;

import java.util.Collections;
import java.util.Stack;
import structure.Graph;
import structure.graph.BasicGraph;

/**
 * @author Japhy
 * @since 2022/5/17 20:06
 */
public class DepthFirstPath implements Paths {

    private boolean[] marked;

    private int s;

    private int[] edgeTo;

    public DepthFirstPath(Graph g, int s) {
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        this.s = s;
        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int i : g.adj(v)) {
            if (!marked[i]) {
                edgeTo[i] = v;
                dfs(g, i);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return Collections.emptyList();
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]) {
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
        Graph graph = new BasicGraph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);

        graph.addEdge(1, 0);
        graph.addEdge(1, 2);

        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 2);

        graph.addEdge(4, 3);
        graph.addEdge(4, 2);

        graph.addEdge(5, 3);
        graph.addEdge(5, 0);

        DepthFirstPath depthFirstPath = new DepthFirstPath(graph, 0);
        System.out.println(depthFirstPath.hasPathTo(3));
        System.out.println(depthFirstPath.pathTo(3));

    }
}
