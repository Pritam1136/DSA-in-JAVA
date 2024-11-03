import java.util.*;

public class BFSTechnique {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    public BFSTechnique(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
        adjacencyList[w].add(v);
    }

    // Function to perform BFS starting from a given node and return the result as a list
    List<Integer> BFS(int startNode) {
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            startNode = queue.poll();
            result.add(startNode);

            for (Integer n : adjacencyList[startNode]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BFSTechnique g = new BFSTechnique(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("Breadth First Traversal starting from node 0:");
        List<Integer> bfsResult = g.BFS(0);
        for (int node : bfsResult) {
            System.out.print(node + " ");
        }
    }
}
