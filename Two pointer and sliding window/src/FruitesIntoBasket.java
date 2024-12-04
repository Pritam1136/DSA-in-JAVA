import java.util.HashMap;

public class FruitesIntoBasket {
    public static int fruitesIntoBasket(int[] arr) {
        HashMap<Integer, Integer> fruitCount = new HashMap<>();
        int maxFruits = 0; // Maximum number of fruits collected
        int start = 0;     // Left pointer of the window

        for (int end = 0; end < arr.length; end++) {
            // Add the current fruit to the basket
            fruitCount.put(arr[end], fruitCount.getOrDefault(arr[end], 0) + 1);

            // Shrink the window if we have more than 2 types of fruits
            while (fruitCount.size() > 2) {
                fruitCount.put(arr[start], fruitCount.get(arr[start]) - 1);
                if (fruitCount.get(arr[start]) == 0) {
                    fruitCount.remove(arr[start]);
                }
                start++; // Move the start pointer
            }

            // Update the maximum fruits collected
            maxFruits = Math.max(maxFruits, end - start + 1);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println("Maximum fruits collected: " + fruitesIntoBasket(arr));
    }
}
