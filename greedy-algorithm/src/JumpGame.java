public class JumpGame {
    public static boolean canJump(int[] nums) {
        int farthest = 0; // Tracks the farthest reachable index

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false; // If the current index exceeds the farthest reachable, we cannot proceed
            }
            farthest = Math.max(farthest, i + nums[i]); // Update the farthest reachable index
            if (farthest >= nums.length - 1) {
                return true; // If we can reach or exceed the last index, return true
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums)); // Output: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums2)); // Output: false
    }
}
