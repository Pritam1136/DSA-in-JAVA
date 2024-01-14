import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leader {
    static void leaderInArray(int[] arr){
        int max = Integer.MIN_VALUE;
        List<Integer> A = new ArrayList<>();
        for (int i = arr.length -1; i > 0; i--) {
            if (max < arr[i]){
                max = arr[i];
                A.add(max);
            }
        }
        Collections.reverse(A);
        for (Integer integer : A) {
            System.out.println(integer);
        }
    }
    public static void main(String[] args) {
        int [] arr = {10, 22, 12, 3, 0, 6};
        leaderInArray(arr);
    }
}
