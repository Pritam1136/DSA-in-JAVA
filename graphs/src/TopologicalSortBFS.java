import java.util.*;

public class TopologicalSortBFS {
    int vertices;
    LinkedList<Integer>[] adjacencyList;

    TopologicalSortBFS(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    public ArrayList<Integer> sort() {
        int[] inDegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (int node : adjacencyList[i]) {
                inDegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : adjacencyList[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (result.size() != vertices) {
            throw new RuntimeException("The graph contains a cycle!");
        }

        return result;
    }

    public static void main(String[] args) {
        TopologicalSortBFS graph = new TopologicalSortBFS(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        ArrayList<Integer> sorted = graph.sort();
        System.out.println("Topological Sort: " + sorted); // Expected output: [4, 5, 0, 2, 3, 1] or any valid topological ordering
    }
}
