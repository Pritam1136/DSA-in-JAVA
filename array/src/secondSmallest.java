import java.util.Scanner;

public class secondSmallest {
    static void secondSmallest(int[] arr) {
        int min = arr[0];
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        int secondSmallest = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < secondSmallest && j != min) {
                secondSmallest = j;
            }
        }
        if (secondSmallest == Integer.MAX_VALUE){
            System.out.println(arr[arr.length - 1]);
        }
        else {
            System.out.println(secondSmallest);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter array element :");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        secondSmallest(arr);
    }
}
