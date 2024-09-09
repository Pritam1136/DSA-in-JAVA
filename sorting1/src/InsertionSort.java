import java.util.Scanner;

public class InsertionSort {
    static void sorting(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
        for (int j : arr) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter 10 numbers for sorting:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        sorting(arr);
    }
}
