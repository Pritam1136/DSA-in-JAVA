public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        System.out.println("Maximum Sum of Non-Adjacent Elements: " + max(arr));
    }

    public static int max(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        // Two variables to store the maximum sum including or excluding the previous element
        int prev1 = arr[0]; // Maximum sum considering only the first element
        int prev2 = 0; // No elements included initially

        // Loop through the array starting from the second element
        for (int i = 1; i < n; i++) {
            int includeCurrent = arr[i] + prev2; // Include the current element
            int excludeCurrent = prev1;          // Exclude the current element

            int currentMax = Math.max(includeCurrent, excludeCurrent); // Maximum sum up to the current element

            // Update prev2 to prev1 and prev1 to currentMax for the next iteration
            prev2 = prev1;
            prev1 = currentMax;
        }

        // The answer will be in prev1, which is the max sum including or excluding the last element
        return prev1;
    }
}
