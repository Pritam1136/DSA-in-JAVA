import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id, deadline, profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    public static int jobScheduling(Job[] jobs) {
        // Step 1: Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 2: Find the maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Step 3: Create a time slot array (default -1 for available slots)
        int[] timeSlots = new int[maxDeadline + 1]; // 1-based indexing
        Arrays.fill(timeSlots, -1);

        int totalProfit = 0;

        // Step 4: Iterate through jobs and assign them to available slots
        for (Job job : jobs) {
            // Find a free slot for this job (start from its deadline)
            for (int j = job.deadline; j > 0; j--) {
                if (timeSlots[j] == -1) { // Slot available
                    timeSlots[j] = job.id; // Assign job to this slot
                    totalProfit += job.profit; // Add profit
                    break;
                }
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job(1, 2, 100),
                new Job(2, 1, 19),
                new Job(3, 2, 27),
                new Job(4, 1, 25),
                new Job(5, 3, 15)
        };

        System.out.println("Maximum profit: " + jobScheduling(jobs));
    }
}
