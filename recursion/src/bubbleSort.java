import java.util.Arrays;
import java.util.Scanner;

public class bubbleSort {
    static void sort(int[] arr, int row) {
        boolean swapped;
        if (row == 0)
            return;
        for (int i = row; i > 0; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (!swapped)
                break;
            sort(arr, --row);
        }
    }
        public static void main (String[]args){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the length of array");
            int n = in.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter array elements");
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            sort(arr,arr.length - 1);
        }
    }