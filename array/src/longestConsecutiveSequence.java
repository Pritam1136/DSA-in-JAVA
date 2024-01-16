import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longestConsecutiveSequence {
    static int consecutive(int [] arr){
        int n = arr.length;
        int longest = 1;
        Set<Integer> ans = new HashSet<Integer>();
        for (int j : arr) {
            ans.add(j);
        }
        for (int item: ans) {
            if (!ans.contains(item -1)){
                int count = 1;
                int x = item;
                while (ans.contains(x + 1)){
                    x ++;
                    count ++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] arr = {102, 4 , 4, 5, 5, 6, 100 , 1, 101, 3, 2, 1, 1, 1, 103, 104, 108, 107, 106, 105, 105};
        int length = consecutive(arr);
        System.out.println(length);
    }
}
