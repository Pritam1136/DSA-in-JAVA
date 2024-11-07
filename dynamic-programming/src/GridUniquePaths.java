public class GridUniquePaths {
    public static int uniquePaths(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        // If the grid is empty or has zero sizes
        if (rows == 0 || cols == 0) return 0;

        // Create a DP array to store the number of unique paths to each cell
        int[][] dp = new int[rows][cols];

        // Initialize the first row and first column,
        // There's only one way to reach cells in the first row and first column
        for (int i = 0; i < rows; i++) {
            dp[i][0] = 1; // Only one way to reach any cell in the first column
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j] = 1; // Only one way to reach any cell in the first row
        }

        // Fill the DP array
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // The bottom-right cell will have the total number of unique paths
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3]; // Example grid of 3x3
        System.out.println("Unique paths in a 3x3 grid: " + uniquePaths(grid)); // Expected output: 6
    }
}
