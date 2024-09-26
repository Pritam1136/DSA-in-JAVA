public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int [] arr = {4,5,6,7,1,2,3};
        int min = Integer.MAX_VALUE;
        int low = 0, high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;
             if (arr[low] <= arr[mid]) {
                 min = Math.min(min, arr[low]);
                 low = mid + 1;
             }
                else{
                    high = mid - 1;
                    min = Math.min(min, arr[mid]);
            }
        }
        System.out.println(min);
    }
}
