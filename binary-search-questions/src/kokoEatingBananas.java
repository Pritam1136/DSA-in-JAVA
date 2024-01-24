import java.util.Scanner;

public class kokoEatingBananas {
    static int findMax(int[] ar){
        int max = Integer.MIN_VALUE;
        int n = ar.length;
        for (int j : ar) {
            max = Math.max(max, j);
        }
        return max;
    }
    static int calculateTotalHour(int hour, int [] arr){
        int totalHour = 0;
        int n = arr.length;

        for (int j : arr) {
            totalHour += (int) Math.ceil(((double) j) / ((double) (hour)));
        }
        return totalHour;
    }
    static int bananasPerHour(int[] arr, int hour){
        int low = 1, high = findMax(arr);

        while (low <= high){
            int mid = (low + high) / 2;
            int totalHour = calculateTotalHour(mid , arr);
            if (totalHour <= hour){
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
        System.out.println("Enter the number of hour");
        int hour = in.nextInt();
        int ans = bananasPerHour(arr, hour);
        System.out.println("KOKO should eat " +ans+ "bananas per hour.");
    }
}
