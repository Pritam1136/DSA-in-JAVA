import java.util.Scanner;

public class findFloorAndCeil {
    static void Floor(int[] arr, int target, int n){
        int low = 0,high = n, ans = -1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] <= target){
                ans = arr[mid];
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println("Ceil is = " + ans);
    }
    static void Ceil(int[] arr, int target, int n){
        int low = 0,high = n, ans = -1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] >= target){
                ans = arr[mid];
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        System.out.println("Floor is = " +ans);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {10,20,30,40,50,60,70};
        int target = in.nextInt();
        Floor(arr, target, arr.length -1);
        Ceil(arr, target, arr.length - 1);
    }
}
