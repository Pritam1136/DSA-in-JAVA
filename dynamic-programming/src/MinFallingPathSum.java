public class MinFallingPathSum {

    // Function to calculate the minimum falling path sum
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Start from the second-to-last row and work upwards
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int down = matrix[row + 1][col];
                int leftDiagonal = (col > 0) ? matrix[row + 1][col - 1] : Integer.MAX_VALUE;
                int rightDiagonal = (col < n - 1) ? matrix[row + 1][col + 1] : Integer.MAX_VALUE;

                // Update the matrix cell with the minimum path sum
                matrix[row][col] += Math.min(down, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // The answer is the minimum value in the top row
        int minPathSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minPathSum = Math.min(minPathSum, matrix[0][col]);
        }

        return minPathSum;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        MinFallingPathSum solution = new MinFallingPathSum();

        // Test case
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        // Print the result
        int result = solution.minFallingPathSum(matrix);
        System.out.println("Minimum Falling Path Sum: " + result);  // Expected output: 13
    }
}
