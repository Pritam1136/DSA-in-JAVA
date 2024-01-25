import java.util.Scanner;

public class shipCapacity {
    static int findMaxInArray(int [] arr){
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            max = Math.max(j, max);
        }
        return max;
    }
    static int sumOfArray(int[] arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }
    static int daysReq(int[] weights, int cap){
        int days = 1; //First day.
        int load = 0;
        for (int weight : weights) {
            if (load + weight > cap) {
                days += 1; //move to next day
                load = weight; //load the weight.
            } else {
                //load the weight on the same day.
                load += weight;
            }
        }
        return days;
    }
    static int leastCapacity(int[] arr, int days){
        int low = findMaxInArray(arr), high = sumOfArray(arr);
        while (low <= high){
            int mid = (high + low)/2;
            int daysReq = daysReq(arr, mid);
            if (daysReq <= days){
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
        System.out.println("Enter the no. of days");
        int days = in.nextInt();
        int ans = leastCapacity(arr, days);
        System.out.println(ans);
    }
}
