import java.util.*;
public class TriangleMinPathSum {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Start from the second last row and go upwards
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int minPath = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, triangle.get(i).get(j) + minPath);
            }
        }

        // The top element now contains the minimum path sum
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );

        TriangleMinPathSum solver = new TriangleMinPathSum();
        int minPathSum = solver.minimumTotal(triangle);
        System.out.println("Minimum Path Sum: " + minPathSum);  // Expected output: 11
    }
}
