import java.util.Arrays;

public class SearchIn2DArray {
    static int[] find(int[][] arr, int target) {
        int low = 0, high = arr.length * arr[0].length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / arr[0].length;
            int col = mid % arr[0].length; // Corrected this line
            if (arr[row][col] == target) {
                return new int[]{row, col};
            } else if (arr[row][col] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] arr = {
                {3, 4, 7, 9},
                {12, 13, 16, 18},
                {20, 21, 23, 29}
        };
        int target = 12;
        System.out.println(Arrays.toString(find(arr, target)));
    }
}
