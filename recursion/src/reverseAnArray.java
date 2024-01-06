import java.util.Scanner;

public class reverseAnArray {
    static void swap(int [] arr, int i, int n) {
            int t = arr[i];
            arr[i] = arr[n - i -1];
            arr[n - i -1] = t;
        }
    static void reverse(int [] arr, int i , int n){
        if (i>= n/2) {
            return;
        }
            swap(arr, i, n);
            reverse(arr, i +1 , n);
    }
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of string :");
        int n = in.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        reverse(arr, 0, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
