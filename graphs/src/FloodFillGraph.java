import java.util.*;

public class FloodFillGraph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public FloodFillGraph(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v); // For undirected graph, add reverse edge
    }

    void floodFill(int startNode, int newColor) {
        int[] colors = new int[vertices];
        Arrays.fill(colors, -1); // Assuming -1 as uncolored

        bfsFill(startNode, newColor, colors);

        // Print out the colors of nodes
        for (int i = 0; i < vertices; i++) {
            System.out.println("Node " + i + " color: " + colors[i]);
        }
    }

    void bfsFill(int startNode, int newColor, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        colors[startNode] = newColor;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer neighbor : adjacencyList[node]) {
                if (colors[neighbor] == -1) { // If not visited
                    queue.add(neighbor);
                    colors[neighbor] = newColor;
                }
            }
        }
    }

    public static void main(String[] args) {
        FloodFillGraph g = new FloodFillGraph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);

        System.out.println("Flood Fill on graph starting from node 0:");
        g.floodFill(0, 2);
    }
}
