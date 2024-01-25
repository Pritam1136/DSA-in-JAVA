import java.util.Scanner;

public class minimumDayToMakeMBouquets {
    static int findMinInArray(int [] arr){
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            min = Math.min(j, min);
        }
        return min;
    }
    static int findMaxInArray(int [] arr){
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            max = Math.max(j, max);
        }
        return max;
    }
    static int isDayPossible(int [] arr, int day, int m, int k){
        int count = 0, noOfBouquet = 0;
        for (int j : arr) {
            if (j <= day) {
                count++;
            } else {
                noOfBouquet += (count / k);
                count = 0;
            }
        }
        noOfBouquet += (count/k);

        if (noOfBouquet >= m)
            return 1;
        return 0;
    }
    static int bouquets(int [] arr, int m, int k){
        if (m*k > arr.length - 1){
            return -1;
        }
        int low = findMinInArray(arr), high = findMaxInArray(arr);
        while (low <= high){
            int mid = (low + high) / 2;
            int dayPossible = isDayPossible(arr, mid, m, k);
            if (dayPossible == 1){
             high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of array");
        int n  = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Enter the number of bouquet");
        int bouquetNumber = in.nextInt();
        System.out.println("Enter the number of adjacent flower required");
        int flowerRequired = in.nextInt();
        int ans = bouquets(arr, bouquetNumber, flowerRequired);
        if (ans == -1){
            System.out.println("not possible");
        } else {
            System.out.println("You need " +ans+ " days");
        }
    }
}
