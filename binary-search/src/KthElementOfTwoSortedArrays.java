public class KthElementOfTwoSortedArrays {
    static int kth(int[] a, int[] b, int k) {
        if (a.length > b.length)
            return kth(b, a, k);

        int n = a.length;
        int m = b.length;
        int low = 0, high = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            int partitionA = mid;
            int partitionB = k - partitionA;

            if (partitionB > m) {
                low = mid + 1;
                continue;
            }
            if (partitionB < 0) {
                high = mid - 1;
                continue;
            }

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : a[partitionA - 1];
            int minRightA = (partitionA == n) ? Integer.MAX_VALUE : a[partitionA];

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : b[partitionB - 1];
            int minRightB = (partitionB == m) ? Integer.MAX_VALUE : b[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                return Math.max(maxLeftA, maxLeftB);
            } else if (maxLeftA > minRightB) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;
        System.out.println(kth(arr1, arr2, k));
    }
}
