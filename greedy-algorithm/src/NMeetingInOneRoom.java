import java.util.*;

public class NMeetingInOneRoom {
    public static int meetings(int[] start, int[] end) {
        int n = start.length;

        // Create a list of meeting pairs (end time, start time)
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{end[i], start[i]});
        }

        // Sort by end time, and by start time if end times are equal
        meetings.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int count = 0;
        int lastEndTime = -1;

        // Iterate through the sorted meetings
        for (int[] meeting : meetings) {
            if (meeting[1] > lastEndTime) { // Start time is after the last meeting's end time
                count++;
                lastEndTime = meeting[0]; // Update the last meeting's end time
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] start = {0, 3, 1, 5, 5, 8};
        int[] end = {5, 4, 2, 9, 7, 9};

        System.out.println("Maximum number of meetings: " + meetings(start, end));
    }
}
