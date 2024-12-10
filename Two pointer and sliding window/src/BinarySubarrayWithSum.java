import java.util.HashMap;

public class BinarySubarrayWithSum {
    public static int subarrayWithGoal(int[] arr, int goal) {
        int l = 0, r = 0;
        int sum = 0, count = 0;

        while (r < arr.length) {
            sum += arr[r];

            // Adjust the left pointer if the sum exceeds the goal
            while (sum > goal) {
                sum -= arr[l];
                l++;
            }

            // Check if the current sum equals the goal
            if (sum == goal) {
                count++;
            }

            // Move the right pointer to the next element
            r++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(subarrayWithGoal(arr, goal)); // Expected Output: 4
    }
}
