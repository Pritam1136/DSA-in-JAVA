import java.util.Scanner;

public class initial {
    static int func(int n, int[] arr){
        int count = 0;
        for (int j : arr) {
            if (n == j) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter the number to search:");
            int n = in.nextInt();
            int [] arr = new int[10];
            System.out.println("Enter 10 numbers.");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
            }
            int count = func(n,arr);
            System.out.println("The numbers of times it appear =" + count);
        }
    }
}