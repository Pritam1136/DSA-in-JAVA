public class JumpGame2 {
    public static int canJump(int[] nums) {
        int jumps = 0;       // Count of jumps
        int currentEnd = 0;  // End of the current range
        int farthest = 0;    // Farthest reachable index

        for (int i = 0; i < nums.length - 1; i++) { // Traverse array (excluding last index)
            farthest = Math.max(farthest, i + nums[i]); // Update farthest reachable

            if (i == currentEnd) { // If we've reached the end of the current range
                jumps++;
                currentEnd = farthest; // Move the range to the farthest point
            }
        }

        return jumps; // Return the total jumps
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums1)); // Output: 2

        int[] nums2 = {1, 2, 1, 1, 1};
        System.out.println(canJump(nums2)); // Output: 3
    }
}
