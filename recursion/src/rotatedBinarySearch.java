import java.util.Scanner;

public class rotatedBinarySearch {
    static int search(int [] arr, int start, int end, int target){
        int mid = start + (end - start) / 2;
        if (start > end)
            return -1;
        if (arr[mid] == target)
            return mid;
        if (arr[start] <= arr[mid]){
            if (target >= arr[start] && target <= arr[mid]){
                return search(arr, start, mid -1, target);
            } else {
                return search(arr, mid + 1, end, target);
            }
        }
        else {
            if (target >= arr[mid] && target <= arr[end]){
                return search(arr, mid + 1, end, target);
            } else {
                return search(arr, start, mid -1, target);
            }
        }
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
        System.out.println("Enter the target");
        int target = in.nextInt();
        System.out.println(search(arr, 0, arr.length-1, target));
    }
}
