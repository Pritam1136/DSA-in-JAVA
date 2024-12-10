import java.util.Arrays;

public class ShortestJobFirst {
    public static int sjf(int[] arr) {
        // Sort the burst times in ascending order
        Arrays.sort(arr);

        int waitingTime = 0; // Accumulates the total waiting time
        int totalWaitingTime = 0; // Sum of waiting times for all processes

        // Calculate waiting time for each process
        for (int j : arr) {
            totalWaitingTime += waitingTime; // Add current waiting time to total
            waitingTime += j; // Update waiting time for the next process
        }

        // Return average waiting time
        return totalWaitingTime / arr.length;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 1, 2}; // Burst times of processes
        System.out.println(sjf(arr)); // Output: Average waiting time
    }
}
