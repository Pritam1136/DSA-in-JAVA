import java.util.Arrays;
import java.util.Scanner;

public class bubbleSort {
        static void print( int[] arr, int count, int row){
            if (count == arr.length)
                return;
            for (int j = 0; j < row; j++) {
                for (int i = 0; i < count; i++) {
                    if (arr[i] > arr[i+1]){
                       arr[i] = arr[i] + arr[i + 1];
                       arr[i + 1] = arr[i] - arr[i + 1];
                       arr[i] = arr[i] - arr[i + 1];
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
            print(arr, ++count, row);
        }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the length of array");
            int n = in.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter array elements");
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            print(arr ,0, n);
        }
}
