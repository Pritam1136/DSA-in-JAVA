public class PainterPartition {
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findSum(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    static int maxSubarray(int[] arr, int num) {
        int count = 1, sum = 0;
        for (int j : arr) {
            if (sum + j <= num) {
                sum += j;
            } else {
                count++;
                sum = j;
            }
        }
        return count;
    }

    static int find(int[] arr, int k) {
        int low = findMax(arr);
        int high = findSum(arr);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (maxSubarray(arr, mid) <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int k = 2;
        System.out.println(find(arr, k));
    }
}
