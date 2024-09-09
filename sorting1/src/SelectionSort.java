import java.util.Scanner;

public class SelectionSort {
    static void sorting(int[] arr) {
        // Selection sort logic
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // Assume the minimum is at position i
            for (int j = i + 1; j < arr.length; j++) {
                // Find the minimum element in the unsorted part of the array
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Update the index of the minimum element
                }
            }
            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter 10 numbers for sorting:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        sorting(arr); // Call the sorting function
    }
}
