import java.util.Scanner;

public class FindPeakElement2 {

    public static int[] findPeakGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Find the column with the max value in the middle row
            int maxCol = findMaxInRow(grid, mid, m);

            // Compare the max element in the middle row with its upper and lower neighbors
            boolean isPeakAbove = mid == 0 || grid[mid][maxCol] > grid[mid - 1][maxCol];
            boolean isPeakBelow = mid == n - 1 || grid[mid][maxCol] > grid[mid + 1][maxCol];

            if (isPeakAbove && isPeakBelow) {
                return new int[]{mid, maxCol}; // Peak found
            } else if (mid > 0 && grid[mid - 1][maxCol] > grid[mid][maxCol]) {
                // If the element above is larger, search in the upper half
                high = mid - 1;
            } else {
                // Otherwise, search in the lower half
                low = mid + 1;
            }
        }

        return new int[]{-1, -1}; // No peak found (shouldn't happen)
    }

    // Helper method to find the index of the maximum element in a row
    private static int findMaxInRow(int[][] grid, int row, int cols) {
        int maxIdx = 0;
        for (int col = 1; col < cols; col++) {
            if (grid[row][col] > grid[row][maxIdx]) {
                maxIdx = col;
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the dimensions of the grid
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Input the grid values
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // Find a peak element
        int[] peak = findPeakGrid(grid);

        System.out.println("Peak found at: [" + peak[0] + ", " + peak[1] + "]");
    }
}