public class FrogJumpWithKJumps {
    public static void main(String[] args) {
        int[] arr = {30, 10, 60, 10, 60, 50};
        int K = 2; // The Maximum number of jumps the frog can take at once
        System.out.println("Minimum cost to reach the last stone: " + jump(arr, K));
    }

    public static int jump(int[] arr, int K) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0; // The Cost to reach the first stone is 0

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE; // Initialize with a large number
            // Consider all possible jumps from i-K to i-1 stones
            for (int j = 1; j <= K; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j] + arr[i]);
                }
            }
        }

        // The minimum cost to reach the last stone
        return dp[n - 1];
    }
}
