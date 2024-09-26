import java.util.Scanner;

public class SqrtUsingBinarySearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = in.nextInt();
        int low = 1, high= n;
        while (low <= high){
           int mid = (low + high) / 2;
           if (mid * mid <= n){
               low = mid+1;
           } else {
               high = mid - 1;
           }
        }
        System.out.println(high);
    }
}
