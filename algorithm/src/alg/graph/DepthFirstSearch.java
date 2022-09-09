package alg.graph;

import structure.Graph;
import structure.graph.BasicGraph;

/**
 * @author Japhy
 * @since 2022/5/17 19:38
 */
public class DepthFirstSearch implements Search {

    private boolean[] marked;

    private int count;

    public DepthFirstSearch(Graph g, int source) {
        marked = new boolean[g.v()];
        dfs(source, g);
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    private void dfs(int v, Graph g) {
        marked[v] = true;
        count++;
        for (int i : g.adj(v)) {
            if (!marked(i)) {
                dfs(i, g);
            }
        }
    }

    @Override
    public int count() {
        return count;
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

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        System.out.println(depthFirstSearch.marked(3));
        System.out.println(depthFirstSearch.count());

    }
}
