public class GridUniquePathsWithObstacles {
    public static int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // If the starting or ending cell has an obstacle, there's no way
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) return 0;

        int[][] dp = new int[rows][cols];

        // Initialize the first cell
        dp[0][0] = 1;

        // Fill the first column
        for (int i = 1; i < rows; i++) {
            dp[i][0] = (grid[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
        }

        // Fill the first row
        for (int j = 1; j < cols; j++) {
            dp[0][j] = (grid[0][j] == 0 && dp[0][j - 1] == 1) ? 1 : 0;
        }

        // Fill the rest with the dp table
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0; // If there's an obstacle, no paths lead here
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        // The Result is in the bottom-right corner
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("Unique paths with obstacles: " + uniquePathsWithObstacles(grid)); // Output: 2
    }
}
