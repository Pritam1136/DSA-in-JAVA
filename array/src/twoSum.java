import java.util.Arrays;

public class twoSum {
    static boolean sum (int[] arr, int n){
        int left = 0;
        int right = arr.length -1;
        Arrays.sort(arr);
        while (left < right){
            int sum = arr[left] + arr[right];
            if ( sum == n){
                return true;
            }
            if (sum < n){
                left ++;
            }
            else right--;
        }
        return false;
    }
    public static int[] TwoSum(int n, int []arr, int target) {
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
    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int n = 14;
//        boolean ans = sum(arr, n);
        int[] answer = TwoSum(arr.length - 1, arr, n);
//        System.out.println(ans);
        System.out.println(Arrays.toString(answer));
    }
}
// TC = O(n)+ O(n log n)
// SC = O(n) or O(1)