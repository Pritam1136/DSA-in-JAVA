import java.util.*;

public class EventualSafeState {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, state)) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean dfs(int node, int[][] graph, int[] state) {
        if (state[node] != 0) {
            return state[node] == 2;
        }

        state[node] = 1;
        for (int neighbor : graph[node]) {
            if (state[neighbor] == 2) {
                continue;
            }
            if (state[neighbor] == 1 || !dfs(neighbor, graph, state)) {
                return false;
            }
        }
        state[node] = 2;
        return true;
    }

    public static void main(String[] args) {
        EventualSafeState solution = new EventualSafeState();
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
        System.out.println("Safe nodes: " + safeNodes); // Output should be [2, 4, 5, 6]
    }
}
