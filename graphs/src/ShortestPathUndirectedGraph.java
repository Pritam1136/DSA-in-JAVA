import java.util.*;

public class ShortestPathUndirectedGraph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public ShortestPathUndirectedGraph(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v); // Since it's an undirected graph
    }

    public void shortestPath(int start, int target) {
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adjacencyList[node]) {
                if (distances[neighbor] == Integer.MAX_VALUE) {
                    distances[neighbor] = distances[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("Shortest path from node " + start + " to node " + target + ": " +
                (distances[target] == Integer.MAX_VALUE ? "Unreachable" : distances[target]));
    }

    public static void main(String[] args) {
        ShortestPathUndirectedGraph graph = new ShortestPathUndirectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        graph.shortestPath(0, 5); // Example: Find the shortest path from node 0 to node 5
    }
}
