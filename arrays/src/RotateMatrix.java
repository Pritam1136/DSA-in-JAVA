import java.util.Arrays;

public class RotateMatrix {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int[] a, int n) {
        for (int i = 0; i < n / 2; i++) {
            swap(a, i, n - i - 1);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int a = arr.length;

        for (int i = 0; i < a; i++) {
            for (int j = i + 1; j < a; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int[] ints : arr) {
            reverse(ints, a);
        }

        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
