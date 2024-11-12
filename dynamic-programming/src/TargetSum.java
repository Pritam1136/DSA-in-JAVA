public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        // Check if (target + sum) is even or greater than a sum
        if ((target + sum) % 2 != 0 || sum < target) return 0;

        int newTarget = (target + sum) / 2;
        return countSubsetsWithSum(nums, newTarget);
    }

    private static int countSubsetsWithSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] numbs = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println("Number of ways: " + findTargetSumWays(numbs, target)); // Expected output: 5
    }
}
