import java.util.Arrays;
import java.util.Scanner;

public class aggressiveCows {
    static int canWePlace(int[] arr, int dist,int cow){
        int count = 1, last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= dist){
                count = count+1;
                last = arr[i];
            }
        }
       if (count >= cow){
           return 1;
       }
       return 0;
    }
    static int minDistance(int[] arr, int num){
        Arrays.sort(arr);
        int low = 1, high = arr[arr.length - 1] - arr[0];
        while (low <= high){
            int mid = (low + high) / 2;
            int isPossible = canWePlace(arr, mid, num);
            if (isPossible == 1)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
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
        System.out.println("Enter the number of cows.");
        int num = in.nextInt();
        int ans = minDistance(arr,num);
        System.out.println(ans);
    }
}
