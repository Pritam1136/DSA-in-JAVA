import java.util.LinkedList;

public class BipartiteGraphUsingBFS {
    int vertices;
    LinkedList<Integer>[] adjacencyList;

    BipartiteGraphUsingBFS(int v) {
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

    boolean isBipartite(int startNode) {
        int[] colors = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            colors[i] = -1;  // -1 means uncolored
        }

        LinkedList<Integer> queue = new LinkedList<>();
        colors[startNode] = 1;  // Start coloring the startNode with color 1
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Integer neighbor : adjacencyList[node]) {
                // If the neighbor hasn't been colored, color it with the opposite color
                if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - colors[node];
                    queue.add(neighbor);
                }
                // If the neighbor has the same color, the graph isn't bipartite
                else if (colors[neighbor] == colors[node]) {
                    return false;
                }
            }
        }
        return true; // If we successfully color the graph, it's bipartite
    }

    public static void main(String[] args) {
        BipartiteGraphUsingBFS g = new BipartiteGraphUsingBFS(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        if (g.isBipartite(0)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
