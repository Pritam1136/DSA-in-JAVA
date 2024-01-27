public class painterPartition {
//    It can also be called split array into K subArray in such a way that the max subArray sum is minimum.
    static int maxInArray(int []arr){
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            max = Math.max(max, j);
        }
        return max;
    }
    static int sumOfArray(int [] arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }
    static int isPossible(int[] arr, int unit){
        int painter = 1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= unit){
                sum += arr[i];
            } else {
                painter++;
                sum = arr[i];
            }
        }
        return painter;
    }
    static int split(int [] arr, int k){
        int low = maxInArray(arr), high = sumOfArray(arr);
        while (low <= high){
            int mid = (low + high) / 2;
            int isPossible = isPossible(arr, mid);
            if (isPossible <= k)
                high = mid -1;
            else
                low = mid + 1;
        }
        return high;
    }
    public static void main(String[] args) {
        int []arr = {10,20,30,40};
        int k = 2;
        System.out.println(split(arr,k));
    }
}
