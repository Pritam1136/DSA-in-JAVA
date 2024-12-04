public class MaxSumSubarray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,1,1,1,1,1,2,3,4,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,3,4,5,3,7};
        int l=0, r= 0, sum = 0, maxLen = 0, k = 25;
        while(r < arr.length){
            sum = sum + arr[r];
            if (sum > k){
                sum = sum - arr[l];
                l = l + 1;
            }
            if (sum <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r = r + 1;
        }
        System.out.println(maxLen);
    }
}
// Constant window
// Longest subarray/substring where there is condition
// Given no. Of subarrays where there is a condition
