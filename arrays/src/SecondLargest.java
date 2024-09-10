import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] arr = new int[10];
        System.out.println("Enter the number");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        int largest = arr[0];
        int sLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest){
                sLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > sLargest) {
                sLargest = arr[i];
            }
        }
        System.out.println(sLargest);
    }
}