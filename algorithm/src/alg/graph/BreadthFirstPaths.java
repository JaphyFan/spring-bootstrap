package alg.graph;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
import structure.Graph;
import structure.graph.BasicGraph;

/**
 * @author Japhy
 * @since 2022/5/18 14:36
 */
public class BreadthFirstPaths implements Paths {

    private boolean[] marked;

    private int[] edgeTo;

    private final int s;

    public BreadthFirstPaths(Graph g, int s) {
        this.s = s;
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        bfs(g, s);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        marked[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
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

        BreadthFirstPaths depthFirstPath = new BreadthFirstPaths(graph, 0);
        System.out.println(depthFirstPath.hasPathTo(3));
        System.out.println(depthFirstPath.pathTo(3));

    }
}
