public class Knapsack {
    public static int knapsack(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[] dp = new int[W + 1];

        // Iterate over each item
        for (int i = 0; i < n; i++) {
            // Update dp array from back to avoid overwriting
            for (int j = W; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], values[i] + dp[j - weights[i]]);
            }
        }

        return dp[W]; // Maximum value for the given weight capacity
    }

    public static void main(String[] args) {
        int[] weights = {3, 4, 5};
        int[] values = {30, 40, 60};
        int capacity = 7;
        System.out.println("Maximum value: " + knapsack(weights, values, capacity));
    }
}
