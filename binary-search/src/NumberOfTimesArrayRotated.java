public class NumberOfTimesArrayRotated {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        int low = 0, high = arr.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the pivot
            if (arr[mid] > arr[mid + 1]) {
                index = mid + 1;
                break;
            }
            if (arr[mid] < arr[mid - 1]) {
                index = mid;
                break;
            }

            // Decide which half to choose for the next step
            if (arr[mid] >= arr[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(index);
    }
}
