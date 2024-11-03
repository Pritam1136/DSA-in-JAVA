import java.util.*;

public class CycleDetectionDirectedDFS {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public CycleDetectionDirectedDFS(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w); // Directed graph
    }

    // DFS to detect cycle in a directed graph
    boolean isCyclic() {
        boolean[] visited = new boolean[vertices];
        boolean[] recursionStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, recursionStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int node, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[node]) {
            return true; // Cycle found
        }

        if (visited[node]) {
            return false; // Already visited
        }

        visited[node] = true;
        recursionStack[node] = true;

        for (int neighbor : adjacencyList[node]) {
            if (isCyclicUtil(neighbor, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        CycleDetectionDirectedDFS g = new CycleDetectionDirectedDFS(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0); // Adding this edge introduces a cycle
        g.addEdge(2, 3);

        System.out.println("Graph contains a cycle: " + g.isCyclic());
    }
}
