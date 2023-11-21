import java.util.Arrays;
import java.util.Scanner;

public class mergeSort {
    static int[] merge(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length /2;
        int[] left = merge(Arrays.copyOfRange(arr, 0, mid));
        int[] right = merge(Arrays.copyOfRange(arr, mid, arr.length));
        return merging(left, right);
    }

    static int[] merging(int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length){
            if (left[i] < right[j]){
                mix[k] = left[i];
                i++;
            } else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }
//        add all the remaining element in the array
            while (i < left.length){
                mix[k] =  left[i];
                i++;
                k++;
            }
            while (j < right.length){
                mix[k] = right[j];
                j++;
                k++;
            }
            return mix;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)){
            System.out.println("Enter the length of array :");
            int n = in.nextInt();
            int [] arr = new int[n];
            System.out.println("Enter the array elements :");
            for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            }
            arr = merge(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}
// merge sort is better because it has better time complexity.