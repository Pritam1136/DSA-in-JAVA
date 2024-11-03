public class NumberOfEnclaves {
    public int enclaves(int[][] arr) {
        if (arr == null || arr.length == 0) return 0;

        int rows = arr.length;
        int cols = arr[0].length;

        // Mark border-connected land cells
        for (int i = 0; i < rows; i++) {
            if (arr[i][0] == 1) dfs(arr, i, 0);
            if (arr[i][cols - 1] == 1) dfs(arr, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            if (arr[0][j] == 1) dfs(arr, 0, j);
            if (arr[rows - 1][j] == 1) dfs(arr, rows - 1, j);
        }

        // Count the remaining land cells (enclaves)
        int enclaveCount = 0;
        for (int[] ints : arr) {
            for (int j = 0; j < cols; j++) {
                if (ints[j] == 1) {
                    enclaveCount++;
                }
            }
        }
        return enclaveCount;
    }

    private void dfs(int[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 1) {
            return;
        }

        board[row][col] = 0; // Mark the cell as visited

        // Explore all 4 directions
        dfs(board, row - 1, col); // Up
        dfs(board, row + 1, col); // Down
        dfs(board, row, col - 1); // Left
        dfs(board, row, col + 1); // Right
    }

    public static void main(String[] args) {
        NumberOfEnclaves obj = new NumberOfEnclaves();
        int[][] arr = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0}
        };
        System.out.println("Number of Enclaves: " + obj.enclaves(arr)); // Output should be 3
    }
}
