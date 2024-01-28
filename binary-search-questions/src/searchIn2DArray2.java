import java.util.Arrays;
import java.util.Scanner;

public class searchIn2DArray2 {
    static int [] search(int[][] arr, int target){
        int n = arr.length - 1;
        int m = arr[0].length;
        int row = 0, column = m - 1;
        while (row < n && column >= 0){
            if (arr[row][column] == target){
                return new int[]{row, column};
            } else if (arr[row][column] < target) {
                row ++;
            } else {
                column --;
            }
        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the target");
        int target = in.nextInt();
        System.out.println("Enter the number of row");
        int n  = in.nextInt();
        System.out.println("Enter the number of column");
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }
       int[] ans = search(arr, target);
        System.out.println(Arrays.toString(ans));
    }
}
// TC: O(n+m)
// SC: O(1)