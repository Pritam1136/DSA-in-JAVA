import java.util.*;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        if (n == 0) return 0;  // Handle an empty matrix case
        if (n == 1) return 1;  // Handle a single node case

        List<List<Integer>> adjacencyList = new ArrayList<>(n);

        // Initialize an adjacency list
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Convert matrix to an adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjacencyList.get(i).add(j);
                }
            }
        }

        // Use DFS to find the number of provinces
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(adjacencyList, visited, i);
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> adjacencyList, boolean[] visited, int v) {
        visited[v] = true;
        for (Integer neighbor : adjacencyList.get(v)) {
            if (!visited[neighbor]) {
                dfs(adjacencyList, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces solution = new NumberOfProvinces();
        int[][] isConnected = {
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 0},
                {0, 1, 0, 1}
        };

        System.out.println("Number of Provinces: " + solution.findCircleNum(isConnected)); // Output should be 2
    }
}
