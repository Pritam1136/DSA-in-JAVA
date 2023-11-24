import java.util.Scanner;

public class quickSort {
    static void quick(int[] arr){

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of array.");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter the element of array:");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        quick(arr);
    }
}
