public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int xor1 = 0, xor2 = 0;

        // XOR all elements of the array
        for (int i = 0; i < arr.length; i++) {
            xor2 ^= arr[i];
        }

        // XOR all numbers from 1 to n (inclusive)
        for (int i = 1; i <= arr.length + 1; i++) {
            xor1 ^= i;
        }

        // The missing number will be the result of xor1 ^ xor2
        System.out.println(xor1 ^ xor2);  // Should print 3
    }
}
