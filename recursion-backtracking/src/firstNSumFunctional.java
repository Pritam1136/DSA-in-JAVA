import java.util.Scanner;

public class firstNSumFunctional {
    static int Sum(int n){
        if (n == 0){
            return 0;
        }
        return n +Sum(n-1);
    }

    public static void main(String[] args) {
        System.out.println("Enter a number to find it's sum :");
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int sum = Sum(n);
            System.out.println("Sum = " + sum);
        }
    }
}
