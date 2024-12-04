public class MaxConsecutiveOnes {
    public static int maxOnes(int[] arr, int k) {
        int maxCount = 0; // Maximum length of subarray with at most k flips
        int zeroCount = 0; // Count of zeros in the current window
        int start = 0; // Start of the sliding window
        int end = 0; // End of the sliding window

        while (end < arr.length) {
            // Expand the window by adding the current element
            if (arr[end] == 0) {
                zeroCount++;
            }

            // Shrink the window if zeroCount exceeds k
            while (zeroCount > k) {
                if (arr[start] == 0) {
                    zeroCount--;
                }
                start++;
            }

            // Update the maximum length
            maxCount = Math.max(maxCount, end - start + 1);

            // Move the end pointer to expand the window
            end++;
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2; // You are allowed to flip k zeros
        System.out.println("Maximum consecutive ones: " + maxOnes(arr, k));
    }
}
