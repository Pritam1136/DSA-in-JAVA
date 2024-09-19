import java.util.Scanner;

public class RecursiveImplementation {
    static int search(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (target < arr[mid]) {
            return search(arr, low, mid - 1, target);
        } else {
            return search(arr, mid + 1, high, target);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {3, 4, 6, 7, 9, 12, 14, 16, 17};
        int n = in.nextInt();
        System.out.println(search(arr, 0, arr.length - 1, n) + 1);
    }
}
