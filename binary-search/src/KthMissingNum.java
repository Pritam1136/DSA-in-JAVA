public class KthMissingNum {
    public static void main(String[] args) {
        int[] arr = {4,7,11};
        int k = 3, missing = 0;
        int low = 0, high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            missing = arr[mid] - (mid + 1);
            if (missing < k){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low + k);
    }
}
