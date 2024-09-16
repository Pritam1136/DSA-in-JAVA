import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,3,3,3,4,4,4,5,5};
        List<List<Integer>> result = fourSum(arr,8);
        for (List<Integer> four : result) {
            System.out.println(four);
        }
    }
    public static List<List<Integer>> fourSum(int[] arr,int target){
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i>0 && arr[i] == arr[i-1]) continue;
            for (int j = i+1; j < arr.length; j++) {
                if (j != i + 1 && arr[j] == arr[j-1]) continue;
                int k= j+1, l = arr.length -1;
                while (k < l){
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == target){
                        result.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        while (k < l && arr[k] == arr[k+1]) k++;
                        while (k < l && arr[l] == arr[l-1]) l--;
                        k++;
                        l--;
                    } else if (sum < 0){
                        k++;
                    } else {
                        l--;
                    }
                }

            }
        }
        return result;
    }
}

// Time complexity = O(n^3)
// Space complexity = O(1)