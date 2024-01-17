import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    static void Sum(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1;
            int k = arr.length - 1;

            while (j < k){
                int sum = arr[i] + arr[j] + arr[k];

                if (sum < 0){
                    j ++;
                }

                else if (sum > 0){
                    k --;
                }
                else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
//                    Skip the duplicates
                    while (j < k && arr[j] == arr[j-1]) j++;
                    while (j < k && arr[k] == arr[k+1]) k--;
                }
            }
        }
        for (List<Integer> List: ans){
            System.out.print("[");
            for (Integer i: List) {
                System.out.print(i + ",");
            }
            System.out.print("] ");
        }
    }
    public static void main(String[] args) {
        int [] arr = {-1, 0, 1, 2, -1, -4};
        Sum(arr);
    }
}
