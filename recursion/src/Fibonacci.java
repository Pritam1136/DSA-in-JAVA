import java.util.Scanner;

public class Fibonacci {
    static int f(int n){
        if (n <= 1)
            return n;
        return f(n-1) + f(n-2);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the term of get it's fibonacci:");
        int n = in.nextInt();
        System.out.println(f(n));
    }
}
// TC = 2^n