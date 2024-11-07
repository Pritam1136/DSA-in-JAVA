public class NinjaTraining {
    public static int maxPoints(int n, int[][] points) {
        int[][] dp = new int[n][3];

        // Initialize for day 0
        dp[0][0] = points[0][0];
        dp[0][1] = points[0][1];
        dp[0][2] = points[0][2];

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            dp[i][0] = points[i][0] + Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = points[i][1] + Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = points[i][2] + Math.max(dp[i - 1][0], dp[i - 1][1]);
        }

        // Maximum points possible on the last day, from any task
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }

    public static void main(String[] args) {
        int[][] points = {
                {10, 50, 1},
                {5, 100, 11},
                {50, 5, 100}
        };
        int n = points.length;

        System.out.println("Maximum points the ninja can achieve: " + maxPoints(n, points));
    }
}
