import java.util.*;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Initialize the queue with all rotten oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // If there are no fresh oranges, return 0
        if (freshOranges == 0) return 0;

        int minutes = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedAny = false;

            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                int row = orange[0];
                int col = orange[1];

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshOranges--;
                        rottedAny = true;
                    }
                }
            }

            if (rottedAny) minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottenOranges solution = new RottenOranges();
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int result = solution.orangesRotting(grid);
        System.out.println("Minutes until no fresh orange remains: " + result); // Output should be 4
    }
}
