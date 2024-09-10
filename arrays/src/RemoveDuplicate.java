import java.util.Arrays;

public class RemoveDuplicate {
    static int[] remove(int[] arr) {
        if (arr.length == 0) return arr;

        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[j] != arr[i]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return Arrays.copyOf(arr, j + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3, 3, 4, 4};
        System.out.println(Arrays.toString(remove(arr)));
    }
}
