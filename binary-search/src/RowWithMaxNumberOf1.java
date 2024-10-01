public class RowWithMaxNumberOf1 {
    static int lowerbound(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (1 <= arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1}
        };

        int maxRow = -1;
        int maxCount = -1;

        for (int i = 0; i < arr.length; i++) {
            int count = arr[i].length - lowerbound(arr[i]);
            if (count > maxCount) {
                maxCount = count;
                maxRow = i;
            }
        }

        System.out.println("Row with maximum number of 1s: " + (maxRow+1));
    }
}
