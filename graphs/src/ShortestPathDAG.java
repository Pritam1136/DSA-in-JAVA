import java.util.*;

public class ShortestPathDAG {
    private int vertices;
    private LinkedList<Edge>[] adjacencyList;

    class Edge {
        int target, weight;
        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    ShortestPathDAG(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w, int weight) {
        adjacencyList[v].add(new Edge(w, weight));
    }

    public void shortestPath(int start) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack);
            }
        }

        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (distances[u] != Integer.MAX_VALUE) {
                for (Edge edge : adjacencyList[u]) {
                    if (distances[edge.target] > distances[u] + edge.weight) {
                        distances[edge.target] = distances[u] + edge.weight;
                    }
                }
            }
        }

        System.out.println("Shortest paths from node " + start + ":");
        for (int i = 0; i < vertices; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("Node " + i + ": Unreachable");
            } else {
                System.out.println("Node " + i + ": " + distances[i]);
            }
        }
    }

    private void topologicalSort(int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (Edge edge : adjacencyList[node]) {
            if (!visited[edge.target]) {
                topologicalSort(edge.target, visited, stack);
            }
        }

        stack.push(node);
    }

    public static void main(String[] args) {
        ShortestPathDAG graph = new ShortestPathDAG(6);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 6);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 4, 4);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, -1);
        graph.addEdge(4, 5, -2);

        graph.shortestPath(1); // Starting node can be changed
    }
}
