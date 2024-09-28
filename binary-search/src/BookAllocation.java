public class BookAllocation {
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

    static int func(int[] arr, int pages) {
        int student = 1, pagesStudent = 0;
        for (int j : arr) {
            if (pagesStudent + j <= pages) {
                pagesStudent += j;
            } else {
                student++;
                pagesStudent = j;
            }
        }
        return student;
    }

    static int allocate(int[] arr, int students) {
        int low = findMax(arr), high = findSum(arr);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (func(arr, mid) <= students) {
                high = mid - 1; // Try to find a smaller maximum
            } else {
                low = mid + 1; // Increase the pages limit
            }
        }
        return low; // Return the minimum possible maximum pages
    }

    public static void main(String[] args) {
        int[] arr = {25, 46, 28, 49, 24};
        int students = 4;
        if (students > arr.length) {
            System.out.println("Not possible");
        } else {
            System.out.println(allocate(arr, students));
        }
    }
}
