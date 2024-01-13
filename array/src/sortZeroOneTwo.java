// Dutch national flag algorithm
public class sortZeroOneTwo {
    static void sort(int[] arr, int n){
        int low = 0; int mid = 0, high = n -1;
        while (mid <= high){
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid ++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high --;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,1,2,2,0,0,0};
         sort(arr,arr.length);
        System.out.println("After sorting : ");
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
