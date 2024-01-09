import java.util.Scanner;

public class bubbleSort {
    static void bubble(int[] arr){
        for (int i = arr.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i ; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter the length of array :");
            int n = in.nextInt();
            int [] arr = new int[n];
            System.out.println("Enter the array elements :");
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            bubble(arr);
        }
    }
}
// time complexity = O(n^2)
