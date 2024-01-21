import java.util.Scanner;

public class lowerBoundAndUpperBoundQuestion {
    static void LowerBound(int [] arr, int target, int n){
        int low = 0,high = n, ans = n;
        while (low <= high){
            int mid = (low + high) / 2;
             if (arr[mid] >= target){
                 ans = mid;
                 high = mid - 1;
            }
            else {
                 low = mid + 1;
            }
        }
        System.out.println(ans + 1);
    }
    static void HigherBound(int[] arr, int target, int n){
        int low = 0,high = n, ans = n;
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] > target){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        System.out.println(ans + 1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {1,2,3,3,7,8,9,9,9,11};
        int target = in.nextInt();
        LowerBound(arr, target, arr.length -1);
        HigherBound(arr, target, arr.length - 1);
    }
}
