public class FrogJump {
    public static void main(String[] args) {
        int[] arr = {30, 10, 60, 10, 60, 50};
        System.out.println("Minimum cost to reach the last stone: " + jump(arr));
    }

    public static int jump(int[] arr) {
        int n = arr.length;

        if (n == 0) return 0; // No stones
        if (n == 1) return arr[0]; // Only one stone

        // Two variables to keep track of the minimum cost to reach the last two stones
        int prev2 = arr[0]; // Cost to reach the first stone
        int prev1 = arr[1]; // Cost to reach the second stone

        // If there's only one stone, return its cost
        if (n == 2) return prev1;

        // Loop from the third stone to the last stone
        for (int i = 2; i < n; i++) {
            // Calculate the minimum cost to reach the current stone
            int current = arr[i] + Math.min(prev1, prev2);
            // Update the previous stones for the next iteration
            prev2 = prev1; // Move prev1 to prev2
            prev1 = current; // Update prev1 to the current cost
        }

        // The result is the cost to reach the last stone
        return prev1;
    }
}
