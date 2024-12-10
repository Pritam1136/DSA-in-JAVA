public class NiceSubarrays {
    private static int atMostK(int[] nums, int k) {
        int l = 0, r = 0, count = 0;
        int length = nums.length;

        while (r < length) {
            // Decrease k for every odd number
            if (nums[r] % 2 != 0) {
                k--;
            }

            // Shrink the window if k < 0
            while (k < 0) {
                if (nums[l] % 2 != 0) {
                    k++;
                }
                l++;
            }

            // Add the number of subarrays ending at index r
            count += (r - l + 1);
            r++;
        }

        return count;
    }

    public static int countNiceSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(countNiceSubarrays(nums, k)); // Output: 2
    }
}
