import java.util.HashMap;
import java.util.Scanner;

public class HashingUsingHashmap {
    static int f(int[] arr, int n) {
        // Create a HashMap to store the frequencies of each number
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Populate the HashMap using a normal for loop
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }

        // Return the frequency of n, or 0 if n is not in the map
        return freqMap.getOrDefault(n, 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number to find its frequency:");
        int n = in.nextInt();
        int[] arr = {1, 1, 2, 2, 2, 2, 4, 3, 3, 1, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8};
        System.out.println(f(arr, n));
    }
}
