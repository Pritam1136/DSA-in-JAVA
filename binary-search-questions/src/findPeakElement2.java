import java.util.Arrays;
import java.util.Scanner;

public class findPeakElement2 {
    static int maxElement(int[][] arr, int mid){
        int index = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][mid] > index){
                index = i;
            }
        }
        return index;
    }
    static int[] findPeak(int [][] arr){
        int n = arr.length, m = arr[0].length;
        int low = 0 , high = arr.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            int row = maxElement(arr, mid);
            int left = mid - 1 >= 0? arr[row][mid - 1] : -1;
            int right = mid + 1 < m? arr[row][mid + 1] : -1;
            if (arr[row][mid] > left && arr[row][mid] > right){
                return new int[]{row ,mid};
            } else if (arr[row][mid] > left) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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
        int[] ans =findPeak(arr);
        System.out.println(Arrays.toString(ans));
    }
}
// TC: O(log(m*n))
// SC: O(1)