import java.util.Scanner;

public class nto1 {

    static void f(int n){
        if (n == 0){
            return;
        }
        System.out.println(n);
        f(n-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = in.nextInt();
        f(n);
    }
}