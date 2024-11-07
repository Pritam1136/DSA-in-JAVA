import java.util.*;

public class NinjaTrainingK {
    public static int maxPoints(int[][] points) {
        int n = points.length;    // Number of days
        int m = points[0].length; // Number of tasks per day

        // Initialize a single 1D array for previous day's results
        int[] prevDay = Arrays.copyOf(points[0], m);

        // Fill the DP table for subsequent days
        for (int i = 1; i < n; i++) {
            int[] currDay = new int[m];
            for (int j = 0; j < m; j++) {
                currDay[j] = points[i][j] + maxPreviousDayPoints(prevDay, j);
            }
            // Move current day's results to the previous day
            prevDay = currDay;
        }

        // The result is the maximum points on the last computed day
        int maxPoints = 0;
        for (int j = 0; j < m; j++) {
            maxPoints = Math.max(maxPoints, prevDay[j]);
        }
        return maxPoints;
    }

    // Helper function to find max points from the previous day, excluding a current task
    private static int maxPreviousDayPoints(int[] previousDayPoints, int excludeIndex) {
        int maxPoints = 0;
        for (int k = 0; k < previousDayPoints.length; k++) {
            if (k != excludeIndex) {
                maxPoints = Math.max(maxPoints, previousDayPoints[k]);
            }
        }
        return maxPoints;
    }

    public static void main(String[] args) {
        int[][] points = {
                {10, 50, 1},
                {5, 100, 11},
                {50, 5, 100}
        };

        System.out.println("Maximum points: " + maxPoints(points)); // Expected output: 210
    }
}
