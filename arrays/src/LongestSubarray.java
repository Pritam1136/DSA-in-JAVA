public class LongestSubarray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1,1,1,1,1,1,1,4,2,3};
        int k = 12;
        int sum = arr[0];
        int left = 0, right = 0;
        int maxlength = 0;
        while(right < arr.length){
            while (left<= right && sum > k){
              sum -= arr[left];
              left++;
            }
            if (sum == k){
                maxlength = Math.max(maxlength, right-left+1);
            }
            right++;
            if (right < arr.length){
                sum += arr[right];
            }
        }
        System.out.println(maxlength);
    }
}
// TC : O(n)