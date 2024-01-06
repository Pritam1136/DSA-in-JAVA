import java.util.Scanner;

public class nto1 {

    static void f(int i, int n){
        if (i > n){
            return;
        }
        f(i+1,n);
        System.out.println(i);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = in.nextInt();
        f(1,n);
    }
}