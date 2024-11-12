public class MinCoins {
    public static int minCoins(int[] coins, int target) {
        int[] dp = new int[target + 1];
        int INF = Integer.MAX_VALUE - 1; // Define infinity to avoid overflow

        // Initialize dp array
        for (int i = 1; i <= target; i++) {
            dp[i] = INF;
        }

        dp[0] = 0; // Base case

        // Populate dp array
        for (int coin : coins) {
            for (int j = coin; j <= target; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
            }
        }

        // If target cannot be achieved, return -1
        return dp[target] == INF ? -1 : dp[target];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int target = 11;
        System.out.println("Minimum coins required: " + minCoins(coins, target)); // Expected output: 3 (5+5+1)
    }
}
