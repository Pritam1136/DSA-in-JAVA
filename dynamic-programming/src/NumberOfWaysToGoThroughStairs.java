public class NumberOfWaysToGoThroughStairs {
    public static void main(String[] args) {
        int n = 5; // Example: number of stairs
        System.out.println("Number of ways to go through " + n + " stairs is: " + numberOfWays(n));
    }

    public static int numberOfWays(int n) {
        if (n <= 1) {
            return 1; // Only one way to go through 0 or 1 stairs
        }

        int prev2 = 1; // Number of ways to reach the 0th stair
        int prev1 = 1; // Number of ways to reach the 1st stair
        int current = 0; // To store the number of ways to reach the current stair

        // Loop from the 2nd stair to the nth stair
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2; // The number of ways to reach the current stair
            prev2 = prev1; // Update prev2 to the previous stair's ways
            prev1 = current; // Update prev1 to the current stair's ways
        }

        return current; // Return the number of ways to reach the nth stair
    }
}
