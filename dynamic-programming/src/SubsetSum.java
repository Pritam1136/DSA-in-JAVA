public class SubsetSum {
    public static boolean subsetSumToTarget(int[] arr, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // A sum of 0 can always be achieved with an empty subset

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int target = 11;
        System.out.println("Is there a subset with sum " + target + "? " + subsetSumToTarget(arr, target));
    }
}
