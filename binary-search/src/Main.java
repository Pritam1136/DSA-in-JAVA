import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] arr = {3,4,6,7,9,12,16,17};
        int low = 0, high = arr.length-1;
        int flag = 0;
        int n = in.nextInt();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == n) {
                flag = 1;
                break;
            }
            else if (n < arr[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        if (flag == 1){
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }
    }
}
// TC:  O(log2 n )