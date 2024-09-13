import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeadersInTheArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2};
        List<Integer> A = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = n-1; i > 0; i--) {
            if (arr[i] > max){
                A.add(arr[i]);
                max = Math.max(max, arr[i]);
            }
        }
        Collections.sort(A);
        System.out.println(A);
    }
}
