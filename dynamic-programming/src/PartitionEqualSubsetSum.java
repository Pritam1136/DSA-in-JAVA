public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If sum is odd, it's impossible to split it into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Sum 0 is always possible with an empty subset

        for (int num : nums) {
            // Traverse backwards to avoid using the same element more than once
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();
        int[] nums = {1, 5, 11, 5};
        System.out.println(solution.canPartition(nums)); // Output: true
    }
}
