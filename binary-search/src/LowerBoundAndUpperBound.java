public class LowerBoundAndUpperBound {
    static int lowerBound(int[] arr, int length, int target){
        int low = 0, high = length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target <= arr[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
    static int upperBound(int[] arr, int length, int target){
        int low = 0, high = length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target < arr[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int [] arr = {3,4,6,7,9,10,12,16,17};
        System.out.println( lowerBound(arr, arr.length, 14));
        System.out.println( upperBound(arr, arr.length, 14));
    }
}
