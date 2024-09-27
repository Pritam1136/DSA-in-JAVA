import java.util.Arrays;

public class KokoEatingBanana {
    static int func(int[] arr, int hour){
        int totalhour = 0;
        for (int j : arr) {
            totalhour += (int) Math.ceil(j / hour);
        }
        return totalhour;
    }
    static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
    static int banana(int[] arr, int k){
        int low = 0, high = max(arr);
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (func(arr,mid) < k){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        int k = 8;
        System.out.println(banana(arr, k));
    }
}
