import java.util.Arrays;

public class SearchIn2DMatrix2 {
    static int[] find(int[][] arr, int target) {
        int row = 0, col = arr[0].length - 1;
        while (row < arr.length && col >= 0) {
            if (arr[row][col] == target) {
                return new int[]{row, col};
            } else if (arr[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 14;
        System.out.println(Arrays.toString(find(arr, target)));
    }
}
