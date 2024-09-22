import java.util.Scanner;

public class SearchRotatedSortedArray1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int low = 0, high = arr.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == n) {
                System.out.println("Element found");
                found = true;
                break;
            }
            // left sorted
            else if (arr[low] <= arr[mid]) {
                if (arr[low] <= n && n <= arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            // right sorted
            else {
                if (arr[mid] <= n && n <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Element not found");
        }
    }
}
