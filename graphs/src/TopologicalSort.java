import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    int vertices;
    LinkedList<Integer>[] adjacencyList;

    TopologicalSort(int v) {
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
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private void dfs(int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (Integer neighbor : adjacencyList[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }

        stack.push(node);
    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        ArrayList<Integer> sorted = graph.sort();
        System.out.println("Topological Sort: " + sorted); // Expected output: [5, 4, 2, 3, 1, 0] or any valid topological ordering
    }
}
