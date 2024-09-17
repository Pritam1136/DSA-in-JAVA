import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int [] arr1 = {1,3,5,7,9};
        int [] arr2 = {0,2,4,6,8,9};
        int n = arr1.length;
        int m = arr2.length;
        int left = n-1;
        int right = 0;
        while (left >= 0 && right < m){
            if (arr1[left] > arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left --;
                right ++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
// TC = O(min(m,n)) + O(n log n) + O(m log m)
// SP = O(1)