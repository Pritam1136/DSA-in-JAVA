import java.util.*;

public class CycleDetectionBFS {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public CycleDetectionBFS(int v) {
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
                if (isCyclicUtil(i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int start, boolean[] visited) {
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjacencyList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = node;
                    queue.add(neighbor);
                } else if (parent[node] != neighbor) {
                    return true; // Cycle found
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetectionBFS g = new CycleDetectionBFS(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4); // Adding this edge introduces a cycle

        System.out.println("Cycle detection using BFS: " + (g.isCyclic() ? "Graph contains a cycle." : "Graph does not contain a cycle."));
    }
}
