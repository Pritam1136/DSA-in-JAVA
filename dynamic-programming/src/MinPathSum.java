public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Initialize the first row and first column for minimum path calculations
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < cols; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // Fill the rest with the grid by taking the minimum of the top or left cell
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        // The bottom-right corner has the result for the minimum path sum
        return grid[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        MinPathSum solution = new MinPathSum();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println("Minimum Path Sum: " + solution.minPathSum(grid)); // Output: 7
    }
}
