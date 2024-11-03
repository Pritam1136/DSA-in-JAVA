import java.util.LinkedList;

public class BipartiteGraph {
    int vertices;
    LinkedList<Integer>[] adjacencyList;

    BipartiteGraph(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    boolean isBipartite() {
        int[] colors = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            colors[i] = -1; // -1 means uncolored
        }

        // Check each component of the graph
        for (int i = 0; i < vertices; i++) {
            if (colors[i] == -1) {
                // Start DFS traversal and color the node
                if (!dfsCheck(i, colors, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfsCheck(int node, int[] colors, int color) {
        colors[node] = color;

        for (Integer neighbor : adjacencyList[node]) {
            // If the neighbor is uncolored, color it with the opposite color
            if (colors[neighbor] == -1) {
                if (!dfsCheck(neighbor, colors, 1 - color)) {
                    return false;
                }
            }
            // If the neighbor has the same color, the graph isn't bipartite
            else if (colors[neighbor] == colors[node]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraph g = new BipartiteGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        if (g.isBipartite()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
