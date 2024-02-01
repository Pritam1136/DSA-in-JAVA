import java.util.Scanner;

public class oneToN {
    static void fun( int n){
        if (n == 0){
            return;
        }
        fun(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = in.nextInt();
        fun(n);
    }
}
