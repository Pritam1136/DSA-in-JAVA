public class firstAndLastOccurrence {
    static int fistOccurrence(int[] arr, int target){
        int n = arr.length-1;
        int low = 0,high = n, ans = n;
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] >= target){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    static int lastOccurrance(int[] arr, int target){
        int n  = arr.length - 1;
        int low = 0,high = n, ans = n;
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] > target){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
       return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,8,8,8,11,13};
        int target = 14;
       int a = fistOccurrence(arr, target);
        int b = lastOccurrance(arr, target);
        b--;
        if (a == arr.length-1 || arr[a] != target){
            System.out.println( -1 +","+ -1);
        } else {
            System.out.println(a +","+ b);
        }
    }
}
