// Kadane's algorithm
public class maxSubarraySum {
    static void maxSum(int[] arr){
        long MAX =  Integer.MIN_VALUE;
        long sum = 0;
        int ansStart = -1, ansEnd = -1;
        int Start = 0;
        for (int i = 0; i < arr.length; i ++) {
            if (sum == 0) {
                Start = i;
            }
            sum += arr[i];

            if (sum > MAX) {
                MAX = sum;
                ansStart = Start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(MAX + " " + " " + ansStart  +" " + " "+ ansEnd);
    }
    public static void main(String[] args) {
        int [] arr = {-2,-3,1,-2,4,5,-1,4,-3,7,-7,-8};
        maxSum(arr);
    }
}
