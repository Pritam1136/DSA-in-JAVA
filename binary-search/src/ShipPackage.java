public class ShipPackage {
    static int sum(int[] arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    static int maxValue(int[] arr) {
        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    static int func(int[] arr, int cap){
        int days = 1; // Start with 1 day
        int load = 0;
        for (int j : arr) {
            if (load + j > cap) {
                days++;
                load = j;
            } else {
                load += j;
            }
        }
        return days;
    }

    static int ship(int[] arr, int days){
        int low = maxValue(arr);
        int high = sum(arr);
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (func(arr, mid) <= days){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(ship(arr, days));
    }
}
