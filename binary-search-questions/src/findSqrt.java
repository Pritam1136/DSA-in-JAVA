import java.util.Scanner;

public class findSqrt {
    static int sqrt(int n){
        int low = 1, high = n;
        while (low <= high){
            int mid = (low + high) / 2;
           if (mid * mid <= n) {
               low = mid + 1;
            } else {
               high = mid - 1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (sqrt(n) == -1){
            System.out.println("Answer not found");
        } else {
            System.out.println(sqrt(n));
        }
    }
}
