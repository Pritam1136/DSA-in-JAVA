import java.util.*;

public class CycleDetectionDFS {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public CycleDetectionDFS(int v) {
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

    boolean isCyclic() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int neighbor : adjacencyList[node]) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, node)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Cycle found
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetectionDFS g = new CycleDetectionDFS(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4); // Adding this edge introduces a cycle

        System.out.println("Cycle detection using DFS: " + (g.isCyclic() ? "Graph contains a cycle." : "Graph does not contain a cycle."));
    }
}
