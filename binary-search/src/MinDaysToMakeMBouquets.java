public class MinDaysToMakeMBouquets {
    public static boolean possible(int[] arr, int day, int m, int k) {
        int n = arr.length; // Size of the array
        int cnt = 0;
        int noOfB = 0;
        // Count the number of bouquets:
        for (int j : arr) {
            if (j <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }
    static int bouque(int[] arr, int m, int k){
        int n = arr.length - 1;
        int max = maxValue(arr);
        int min = minValue(arr);
        if (m*k > n){
           return -1;
        }
        while (min <= max){
            int mid = min + (max -min) / 2;
            if (possible(arr, mid, m, k)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }

        }
        return min;
    }
    static int maxValue(int[] chars) {
        int max = chars[0];
        for (int aChar : chars) {
            if (aChar > max) {
                max = aChar;
            }
        }
        return max;
    }
    static int minValue(int[] chars) {
        int min = chars[0];
        for (int aChar : chars) {
            if (aChar < min) {
                min = aChar;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int [] arr = {7,7,7,7,13,11,12,7};
        int m = 2,k = 3,n= arr.length - 1;
        System.out.println(bouque(arr,m,k));
    }
}
