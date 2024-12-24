import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals by end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int lastEnd = Integer.MIN_VALUE;
        int removalCount = 0;

        for (int[] interval : intervals) {
            if (interval[0] >= lastEnd) {
                // Include this interval
                lastEnd = interval[1];
            } else {
                // Remove this interval
                removalCount++;
            }
        }

        return removalCount;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Minimum intervals to remove: " + eraseOverlapIntervals(intervals));
    }
}
