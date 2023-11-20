import java.util.Scanner;

public class selectionSort {
    static void selection(int[] arr){
        for (int i = 0; i < arr.length -1; i++) {
            for (int k = i; k < arr.length ; k++) {
                if (arr[k] < arr[i]){
                    int temp = arr[k];
                    arr[k] = arr[i];
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
            int [] arr = new int[n];
            System.out.println("Enter the array elements :");
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            selection(arr);
        }
    }
}
// time complexity = O(n^2)