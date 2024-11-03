import java.util.*;

public class DFSTechnique {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    public DFSTechnique(int v) {
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

    // DFS utility function
    private void DFSUtil(int v, boolean[] visited, List<Integer> result) {
        visited[v] = true;
        result.add(v);

        for (Integer n : adjacencyList[v]) {
            if (!visited[n]) {
                DFSUtil(n, visited, result);
            }
        }
    }

    // Function to perform DFS starting from a given node and return the result as a list
    List<Integer> DFS(int startNode) {
        boolean[] visited = new boolean[vertices];
        List<Integer> result = new ArrayList<>();
        DFSUtil(startNode, visited, result);
        return result;
    }

    public static void main(String[] args) {
        DFSTechnique g = new DFSTechnique(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("Depth First Traversal starting from node 2:");
        List<Integer> dfsResult = g.DFS(2);
        for (int node : dfsResult) {
            System.out.print(node + " ");
        }
    }
}
