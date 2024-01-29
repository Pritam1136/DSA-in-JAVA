import java.util.Scanner;

public class KthMissing {
    static int findMissing(int [] arr, int k){
        int low = 0, high = arr.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + low;
//        or return k + high - 1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of array");
        int n  = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Enter the position of missing number.");
        int num = in.nextInt();
        int ans = findMissing(arr,num);
        System.out.println(ans);
    }
}
