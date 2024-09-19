public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 2, 3, -5, -2};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxProduct = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                currMax = 1;
                currMin = 1;
                maxProduct = Math.max(maxProduct, 0);
                continue;
            }

            int tempMax = currMax;
            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(tempMax * nums[i], currMin * nums[i]));

            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
    }
}
