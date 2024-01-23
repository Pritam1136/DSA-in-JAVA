public class findPeakElement {
    static int search(int[] arr) {
        int n = arr.length;
        int low = 1, high = n - 2, ans = -1;
        if (n == 1){
            return arr[0];
        }
        if (arr[0] > arr[arr[1]]){
            return arr[0];
        }
        if (arr[n-1] > arr[n-2]) {
            return arr[n-1];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return arr[mid];
            }
            if (arr[mid] > arr[mid-1]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,5,1};
        int[] arr1 = {1,2,3,4,5,6};
        int ans = search(arr1);
        System.out.println(ans);
    }
}
