import java.util.Arrays;

public class RearrangeZeroOneTwo {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,2,1,0,1,2,2,0,0,1,1,1,0,2,1,0};
        int low = 0, mid = 0, high = arr.length-1;
        while(mid <= high){
            if (arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1){
                mid++;
            } else {
                swap(arr, high, mid);
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
