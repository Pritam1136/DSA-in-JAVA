import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    static void spiral(int[][] arr){
        int n = arr.length;
        int m =arr[0].length;
        int top = 0, right = m - 1, left = 0, bottom = n - 1;
        List<Integer> ans = new ArrayList<>();

        while (top <= bottom && left <= right) {

            // For moving left to right
            for (int i = left; i <= right; i++)
                ans.add(arr[top][i]);

            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++)
                ans.add(arr[i][right]);

            right--;

            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(arr[bottom][i]);

                bottom--;
            }

            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(arr[i][left]);

                left++;
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] [] arr = {{1,2,3,4,5,6},{20,21,22,23,24,7},{19,32,33,34,25,8},{18,31,36,35,26,9},{17,30,29,28,27,10},{16,15,14,13,12,11}};
       
        spiral(arr);
    }
}
