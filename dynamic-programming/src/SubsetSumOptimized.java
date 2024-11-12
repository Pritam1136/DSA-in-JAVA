public class SubsetSumOptimized {
    public static int countSubsets(int[] arr, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: one way to achieve sum 0 (empty subset)

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1};
        int target = 1;
        System.out.println("Number of subsets with sum " + target + " is: " + countSubsets(arr, target));
    }
}
