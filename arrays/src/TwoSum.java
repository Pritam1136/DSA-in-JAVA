import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int n, int []arr, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
    static boolean Sum(int[] arr,int target){
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        while (left < right){
            int sum = arr[left] + arr[right];
            if (sum == target)
                return true;
            if (sum < target)
                left++;
            else
                right--;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        System.out.println(Sum(arr,7));
        System.out.println(Arrays.toString(twoSum(arr.length, arr, 11)));
    }
}
// TC: O(n) + O(n log n)
