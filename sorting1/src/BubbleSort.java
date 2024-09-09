import java.util.Scanner;

public class BubbleSort {
    static void sorting(int[] arr) {
        // Selection sort logic
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                // Find the minimum element in the unsorted part of the array
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 10 numbers for sorting:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        sorting(arr); // Call the sorting function
    }
}
