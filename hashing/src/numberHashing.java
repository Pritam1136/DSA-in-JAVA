import java.util.Scanner;

public class numberHashing {
    static int f(int[] arr, int n) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        // Create an array with size max + 1 to handle all indices from 0 to max
        int[] newArr = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[arr[i]]++;
        }
        // Check if n is within valid range
        if (n <= max)
            return newArr[n];
        else
            return 0; // return 0 if n is out of range
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number to find its frequency:");
        int n = in.nextInt();
        int[] arr = {1, 1, 2, 2, 2, 2, 4, 3, 3, 1, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8};
        System.out.println(f(arr, n));
    }
}
