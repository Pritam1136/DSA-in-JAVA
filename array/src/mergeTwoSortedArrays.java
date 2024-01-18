import java.util.Arrays;

// without extra space
public class mergeTwoSortedArrays {
    static void sorted (int [] arr1, int [] arr2){
        int n = arr1.length;
        int m = arr2.length;
        // Declare 2 pointers:
        int left = n - 1;
        int right = 0;

        // Swap the elements until arr1[left] is
        // smaller than arr2[right]:
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = (int) temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort arr1[] and arr2[] individually:
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1) +"----"+Arrays.toString(arr2));
    }
    public static void main(String[] args) {
        int [] arr1 = {1,3,5,7};
        int [] arr2 = {0,2,4,6,8};
        sorted(arr1 , arr2);
    }
}
// TC: O(min(m,n)) + O(n log(n)) + O(m log(m))
// SC: O(1)