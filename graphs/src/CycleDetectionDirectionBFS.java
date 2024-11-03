import java.util.*;

public class CycleDetectionDirectionBFS {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public CycleDetectionDirectionBFS(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w); // Directed graph
    }

    boolean isCyclic() {
        int[] inDegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (int node : adjacencyList[i]) {
                inDegree[node]++;
//                System.out.println(inDegree[node]);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int neighbor : adjacencyList[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If the count of visited nodes is not equal to the number of vertices, there is a cycle
        return count != vertices;
    }

    public static void main(String[] args) {
        CycleDetectionDirectionBFS graph = new CycleDetectionDirectionBFS(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0); // Adding this edge introduces a cycle
        graph.addEdge(2, 3);

        System.out.println("Graph contains a cycle: " + graph.isCyclic());
    }
}
