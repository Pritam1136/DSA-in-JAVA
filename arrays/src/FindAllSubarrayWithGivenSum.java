import java.util.*;

public class FindAllSubarrayWithGivenSum {
    public static int findAllSubarraysWithGivenSum(int[] arr, int k) {
        int n = arr.length; // size of the given array.
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int prefixSum = 0, count = 0;

        prefixSumCount.put(0, 1); // Setting 0 in the map.
        for (int j : arr) {
            // Add current element to prefix sum:
            prefixSum += j;

            // Calculate prefixSum - k:
            int target = prefixSum - k;

            // Add the number of subarrays to be removed:
            count += prefixSumCount.getOrDefault(target, 0);

            // Update the count of prefix sum in the map:
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        int count = findAllSubarraysWithGivenSum(arr, k);
        System.out.println("The number of subarrays is: " + count);
    }
}
