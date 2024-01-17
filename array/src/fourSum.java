import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Same logic as of three sum problem.
public class fourSum {
    static void Sum(int[] nums, int target){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }
        for (List<Integer> list: ans){
            System.out.print("[");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(i + " ");
            }
            System.out.print("]");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        Sum(arr, 0);
    }
}
