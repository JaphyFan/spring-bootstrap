package structure.graph;

import structure.Graph;

/**
 * @author Japhy
 * @since 2022/5/17 15:16
 */
public class GraphUtil {

    /**
     * 计算度数.
     *
     * @param g
     * @param v
     * @return
     */
    public static int degree(Graph g, int v) {
        int degree = 0;
        for (int w : g.adj(v)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph g) {
        int max = 0;
        for (int v = 0; v < g.v(); v++) {
            if (degree(g, v) > max) {
                max = degree(g, v);
            }
        }
        return max;
    }

    public static int numberOfSelfLoops(Graph graph) {
        int count = 0;
        for (int v = 0; v < graph.v(); v++) {
            for (int w : graph.adj(v)) {
                if (v==w) {
                    count++;
                }
            }
        }
        return count / 2;
    }

}
