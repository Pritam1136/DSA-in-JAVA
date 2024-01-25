import java.util.Scanner;

public class smallestDivisor {
    static int findMinInArray(int [] arr){
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            min = Math.min(j, min);
        }
        return min;
    }
    static int findMaxInArray(int [] arr){
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            max = Math.max(j, max);
        }
        return max;
    }
    static int calculateTotalThreshold(int hour, int [] arr){
        int totalHour = 0;

        for (int j : arr) {
            totalHour += (int) Math.ceil(((double) j) / ((double) (hour)));
        }
        return totalHour;
    }
    static int findThreshold(int[] arr, int t){
        int low = findMinInArray(arr), high = findMaxInArray(arr);

        while (low <= high){
            int mid = (low + high) / 2;
            int totalThreshold = calculateTotalThreshold(mid , arr);
            if (totalThreshold <= t){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
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
        System.out.println("Enter the threshold");
        int t = in.nextInt();
        int ans = findThreshold(arr, t);
        System.out.println(ans);
    }
}
