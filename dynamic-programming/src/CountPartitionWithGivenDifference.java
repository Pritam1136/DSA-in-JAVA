public class CountPartitionWithGivenDifference {

    public static int countPartitionsWithDifference(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // Check if it's possible to partition
        if ((totalSum + diff) % 2 != 0 || diff > totalSum) return 0;

        int target = (totalSum + diff) / 2;
        return countSubsetsWithSum(arr, target);
    }

    private static int countSubsetsWithSum(int[] arr, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // There's one way to have a sum of 0 (empty subset)

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;
        int result = countPartitionsWithDifference(arr, diff);
        System.out.println("Number of partitions with given difference: " + result);
    }
}
