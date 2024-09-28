public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) {
            return findMedianSortedArrays(b, a); // Ensure a is the smaller array
        }

        int n = a.length;
        int m = b.length;
        int low = 0, high = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            int partitionA = mid;
            int partitionB = (n + m + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : a[partitionA - 1];
            int minRightA = (partitionA == n) ? Integer.MAX_VALUE : a[partitionA];

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : b[partitionB - 1];
            int minRightB = (partitionB == m) ? Integer.MAX_VALUE : b[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((n + m) % 2 == 0) {
                    return ((double)Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
                } else {
                    return (double)Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        int[] a = {2, 4, 6};
        int[] b = {1, 3, 5};
        System.out.println(solution.findMedianSortedArrays(a, b)); // Output: 3.5
    }
}
