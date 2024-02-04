import java.util.Arrays;
import java.util.Scanner;

public class quickSort {
    static void quick(int[] arr, int low, int high){
        if (low >= high)
            return;

        int start = low;
        int end = high;
        int mid =  start + (end - start) / 2;
        int pivot = arr[mid];

        while (start <= end){
            while (arr[start] < pivot)
                start ++;
            while (arr[end] > pivot)
                end --;
            if (start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quick(arr, low, end);
        quick(arr, start, high);
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
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
/*
 Time complexity = O(n^2)
 Space complexity = O(1)
*/
