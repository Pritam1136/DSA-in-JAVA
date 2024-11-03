import java.util.*;

public class EventualSafeStatesBFS {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];

        // Reverse the graph and calculate in-degrees
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                reverseGraph.get(v).add(u);
                inDegree[u]++;
            }
        }

        // Initialize the queue with nodes having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Perform BFS
        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);

            for (int neighbor : reverseGraph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        Collections.sort(safeNodes); // Return nodes in sorted order
        return safeNodes;
    }

    public static void main(String[] args) {
        EventualSafeStatesBFS solution = new EventualSafeStatesBFS();
        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        List<Integer> safeNodes = solution.eventualSafeNodes(graph);
        System.out.println("Safe nodes: " + safeNodes); // Expected output: [2, 4, 5, 6]
    }
}

