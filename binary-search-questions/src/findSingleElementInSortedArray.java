public class findSingleElementInSortedArray {
    static void search(int[] arr) {
        int n = arr.length;
        int low = 1, high = n - 2, ans = -1;
        if (n == 1)
            System.out.println(arr[0]);
        if (arr[0] != arr[1])
            System.out.println(arr[0]);
        if (arr[n-1] != arr[n-2])
            System.out.println(arr[n-1]);
        else {
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid - 1] != arr[mid] && arr[mid] != arr[mid+1]){
                    ans = arr[mid];
                    break;
                }
                else if ((mid % 2 == 1 && arr[mid] == arr[mid-1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            System.out.println(ans);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,5,5,6,6,7,7,8,8,9,9};
        search(arr);
    }
}
