import java.util.Scanner;

public class isArraySorted {
    static boolean isSorted(int[] arr, int n){
        if (n == arr.length - 1)
            return true;
        if (arr[n] > arr[n+1])
            return false;
        else
            return isSorted(arr, ++n);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of array :");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter array elements :");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(isSorted(arr,0));
    }
}
