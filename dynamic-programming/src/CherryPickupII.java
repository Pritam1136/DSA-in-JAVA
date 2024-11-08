import java.util.Arrays;

public class CherryPickupII {

    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];

        for (int[][] row : dp) {
            for (int[] r : row) {
                Arrays.fill(r, -1);
            }
        }

        return calculateMaxCherries(0, 0, cols - 1, grid, dp);
    }

    private int calculateMaxCherries(int row, int col1, int col2, int[][] grid, int[][][] dp) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return 0;
        }

        if (dp[row][col1][col2] != -1) {
            return dp[row][col1][col2];
        }

        int result = grid[row][col1];
        if (col1 != col2) {
            result += grid[row][col2];
        }

        if (row != rows - 1) {
            int maxCherries = 0;
            for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                    maxCherries = Math.max(maxCherries, calculateMaxCherries(row + 1, newCol1, newCol2, grid, dp));
                }
            }
            result += maxCherries;
        }

        dp[row][col1][col2] = result;
        return result;
    }

    public static void main(String[] args) {
        CherryPickupII cp = new CherryPickupII();
        int[][] grid = {
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
        };

        System.out.println("Maximum cherries collected: " + cp.cherryPickup(grid)); // Expected output: 24
    }
}
