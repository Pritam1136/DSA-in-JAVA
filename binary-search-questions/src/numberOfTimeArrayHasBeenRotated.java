public class numberOfTimeArrayHasBeenRotated {
    static void search(int[]arr){
        int n = arr.length;
        int low = 0,high = n - 1,ans = -1;
        while (low <= high){
            int mid = (low + high)/2;
            if (arr[low] <= arr[high]){
                ans = low;
                break;
            }
//            left sorted
            if (arr[low] <= arr[mid]){
                ans = low;
                low = mid + 1;
            }
//            right sorted
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,9,1,2,3};
        search(arr);
    }
}
