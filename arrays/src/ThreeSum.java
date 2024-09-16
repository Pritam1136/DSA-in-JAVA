import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-2, -2, -2, -1, -1, -1, 0, 0, 0, 2, 2, 2, 2};
        List<List<Integer>> result = threeSum(arr);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++; // Skip duplicates
                    while (j < k && nums[k] == nums[k - 1]) k--; // Skip duplicates
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
