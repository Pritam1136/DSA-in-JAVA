import java.util.HashMap;
import java.util.Map;

public class subarrayXORExualsK {
    static void subarray(int [] arr, int k){
        int n = arr.length; // size of the given array.
        Map<Integer, Integer> mpp = new HashMap<>();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // XOR current element to prefix Sum:
            preSum ^= arr[i];

            // Calculate x^k:
            int remove = preSum ^ k;

            // Add the number of subarrays to be removed:
            cnt += mpp.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) {
        int arr[] = {4,2,2,6,4};
        int k = 6;
        subarray(arr , k);
    }
}
