public class AggressiveCows {
    static boolean canWePlace(int[] arr,int dist,int cows){
        int count = 1, last = arr[0];
        for (int j : arr) {
            if (j - last >= dist) {
                count++;
                last = j;
            }
        }
        return count >= cows;
    }
    static int cows(int[] arr, int cows){
        int low = 0, high = arr[arr.length - 1] - arr[0];
        while (low <= high){
            int mid = (low + high) / 2;
            if (canWePlace(arr, mid, cows)){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        int [] arr = {0,3,4,7,9,10};
        int cows = 2;
        System.out.println(cows(arr,cows));
    }
}
