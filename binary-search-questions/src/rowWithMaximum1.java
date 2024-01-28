public class rowWithMaximum1 {
    static int findMax(int [] arr, int target, int n){
        int low = 0,high = n -1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] >= target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] [] arr = {{0,0,1,1,1},{0,0,0,0,0},{0,1,1,1,1},{0,0,0,0,1},{0,1,1,1,1}};
        int count = -1;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            int m = arr[i].length;
            int cnt  = m - findMax(arr[i],1, arr[i].length);
            if (cnt > count){
                count = cnt;
                index = i;
            }
        }
        System.out.println(count);
        System.out.println(index);
    }
}
