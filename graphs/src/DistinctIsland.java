import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class DistinctIsland {
    public int countDistinctIslands(int[][] grid) {
        Set<String> uniqueIslands = new HashSet<>();
        int rows = grid.length, cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    List<String> pathSignature = new ArrayList<>();
                    dfs(grid, i, j, i, j, pathSignature);
                    uniqueIslands.add(pathSignature.toString());
                }
            }
        }

        return uniqueIslands.size();
    }

    private void dfs(int[][] grid, int row, int col, int baseRow, int baseCol, List<String> pathSignature) {
        // Check bounds and if cell is not land
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return;
        }

        // Mark cell as visited
        grid[row][col] = 0;

        // Record relative position
        pathSignature.add((row - baseRow) + "," + (col - baseCol));

        // Explore all 4 directions
        dfs(grid, row - 1, col, baseRow, baseCol, pathSignature); // Up
        dfs(grid, row + 1, col, baseRow, baseCol, pathSignature); // Down
        dfs(grid, row, col - 1, baseRow, baseCol, pathSignature); // Left
        dfs(grid, row, col + 1, baseRow, baseCol, pathSignature); // Right
    }

    public static void main(String[] args) {
        DistinctIsland obj = new DistinctIsland();
        int[][] grid1 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        int[][] grid2 = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };
        System.out.println("Distinct Islands in Grid1: " + obj.countDistinctIslands(grid1)); // Output: 1
        System.out.println("Distinct Islands in Grid2: " + obj.countDistinctIslands(grid2)); // Output: 3
    }
}
