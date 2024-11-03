import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearest1 {
    public int[][] distanceOf1(int[][] grid) {
        if (grid == null || grid.length == 0)
            return new int[0][0];

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distance = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        // Initialize distances and enqueue all 1's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (distance[newRow][newCol] > distance[row][col] + 1) {
                        distance[newRow][newCol] = distance[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 0, 1}
        };

        DistanceOfNearest1 solution = new DistanceOfNearest1();
        int[][] result = solution.distanceOf1(grid);

        System.out.println("Distance of nearest 1 for each cell:");
        for (int[] row : result) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
