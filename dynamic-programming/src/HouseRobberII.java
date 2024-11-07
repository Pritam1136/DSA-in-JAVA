public class HouseRobberII {
    public int rob(int[] houses) {
        if (houses.length == 1) return houses[0]; // If only one house, rob it.
        if (houses.length == 0) return 0; // If no houses, return 0.

        // Case 1: Exclude the last house
        int maxExcludingLast = robLinear(houses, 0, houses.length - 2);
        // Case 2: Exclude the first house
        int maxExcludingFirst = robLinear(houses, 1, houses.length - 1);

        // Maximum of both cases
        return Math.max(maxExcludingLast, maxExcludingFirst);
    }

    private int robLinear(int[] houses, int start, int end) {
        int prev1 = 0; // max sum including the current house
        int prev2 = 0; // max sum excluding the current house

        for (int i = start; i <= end; i++) {
            int includeCurrent = houses[i] + prev2;
            int excludeCurrent = prev1;

            // Calculate the max sum at this position
            int currentMax = Math.max(includeCurrent, excludeCurrent);

            // Update for the next iteration
            prev2 = prev1;
            prev1 = currentMax;
        }
        return prev1;
    }

    public static void main(String[] args) {
        HouseRobberII robber = new HouseRobberII();
        int[] houses = {2, 3, 2};
        System.out.println("Max amount robbed: " + robber.rob(houses)); // Expected output: 3
    }
}
