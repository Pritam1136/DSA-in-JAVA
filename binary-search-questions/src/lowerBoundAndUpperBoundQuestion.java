import java.util.Scanner;

public class lowerBoundAndUpperBoundQuestion {
    static void LowerBound(int [] arr, int target, int n){
        int low = 0,high = n;
        while (low <= high){
            int mid = (low + high) / 2;
             if (arr[mid] >= target){
                 high = mid - 1;
            }
            else {
                 low = mid + 1;
            }
        }
        System.out.println(low);
    }
    static void HigherBound(int[] arr, int target, int n){
        int low = 0,high = n;
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {1,2,3,3,7,8,9,9,9,11};
        int target = in.nextInt();
        LowerBound(arr, target, arr.length -1);
        HigherBound(arr, target, arr.length - 1);
    }
}
