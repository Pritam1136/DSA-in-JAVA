import java.util.Scanner;

public class binarySearch {
    static int search(int[] arr, int low, int high, int target){
        if (low > high){
            return -1;
        }
            int mid = (low + high) / 2;

            if (arr[mid] == target){
                return mid;
            }
            if (arr[mid] < target){
               return search(arr, mid+1, high, target);
            }
            else {
               return search(arr, low, mid-1, target);
            }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of array :");
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter the array array elements :");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Enter the target");
        int target = in.nextInt();
        System.out.println(search(arr, 0, n, target));
    }
}
