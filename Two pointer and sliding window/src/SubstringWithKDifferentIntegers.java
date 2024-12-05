import java.util.HashMap;

public class SubstringWithKDifferentIntegers {

    // Helper method to count substrings with at most K distinct integers
    private static int atMostKDistinct(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, count = 0;

        while (r < arr.length) {
            // Add the current number at the right pointer to the map
            int current = arr[r];
            map.put(current, map.getOrDefault(current, 0) + 1);

            // If the map size exceeds K, shrink the window from the left
            while (map.size() > k) {
                int leftNum = arr[l];
                map.put(leftNum, map.get(leftNum) - 1);

                if (map.get(leftNum) == 0) {
                    map.remove(leftNum);
                }
                l++; // Move the left pointer
            }

            // Add all substrings ending at the current right pointer
            count += r - l + 1;
            r++; // Move the right pointer
        }

        return count;
    }

    // Main method to count substrings with exactly K distinct integers
    public static int substringsWithKDistinct(int[] arr, int k) {
        return atMostKDistinct(arr, k) - atMostKDistinct(arr, k - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 2, 3, 5, 4};
        int k = 3;
        System.out.println("Number of substrings with exactly " + k + " distinct integers: " + substringsWithKDistinct(arr, k));
    }
}
