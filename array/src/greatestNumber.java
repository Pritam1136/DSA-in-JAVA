import java.util.Scanner;

public class greatestNumber {
    static void largest(int[] arr){
//        O(n)
        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        System.out.println(max);
    }
    static void secondlardest(int[] arr){
//        O2(n)
        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        int secondLargest = -1;
        for (int j : arr) {
            if (j > secondLargest && j != max) {
                secondLargest = j;
            }
        }
        System.out.println(secondLargest);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter array element :");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        largest(arr);
        secondlardest(arr);
    }
}
// Maximum size of array that you can define in main function is 10^6
// and the maximum size of array that you can define globally is 10^7
// It's a linear data structure