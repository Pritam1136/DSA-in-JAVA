import java.util.Scanner;

public class insertionSort {
    static void insertion(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
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
            int[] arr = new int[n];
            System.out.println("Enter the array elements :");
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            insertion(arr);
        }
    }
}
// time complexity = O(n^2)