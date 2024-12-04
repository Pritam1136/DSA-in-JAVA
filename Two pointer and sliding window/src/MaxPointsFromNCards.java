public class MaxPointsFromNCards {
    public static int maxPoints(int[] nums, int k) {
        int lsum = 0, rsum = 0, maxSum = 0;

        // Calculate the initial sum of the first k elements
        for (int i = 0; i < k; i++) {
            lsum += nums[i];
        }

        maxSum = lsum;

        int rindex = nums.length - 1;

        // Move elements from left to right
        for (int i = k - 1; i >= 0; i--) {
            lsum -= nums[i]; // Remove the last element from left
            rsum += nums[rindex]; // Add the last element from right
            rindex--;
            maxSum = Math.max(maxSum, lsum + rsum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 7, 2, 1, 7, 1};
        int k = 4;
        int result = maxPoints(arr, k);
        System.out.println("Maximum points: " + result);
    }
}
