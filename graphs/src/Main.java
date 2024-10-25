import java.util.*;

public class Main {
    private int vertices;
    private LinkedList<Integer> adjacencyList[];

    // Constructor
    public Main(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adjacencyList[v].add(w); // Add w to v's list.
    }

    // Function to print the adjacency list representation of graph
    void printGraph() {
        for (int i = 0; i < vertices; ++i) {
            System.out.print("Vertex " + i + ":");
            for (Integer node : adjacencyList[i]) {
                System.out.print(" -> " + node);
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Main g = new Main(5);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();
    }
}
