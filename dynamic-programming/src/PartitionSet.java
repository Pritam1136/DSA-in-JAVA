public class PartitionSet {
    public int minimumDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // A sum of 0 is always achievable with an empty subset

        for (int num : nums) {
            // Update dp in reverse order to prevent using the same element more than once
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        int closestSum = 0;
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                closestSum = i;
                break;
            }
        }

        return Math.abs(sum - 2 * closestSum);
    }

    public static void main(String[] args) {
        PartitionSet solution = new PartitionSet();
        int[] nums = {1, 2, 3, 9};
        System.out.println(solution.minimumDifference(nums)); // Output: 3
    }
}
