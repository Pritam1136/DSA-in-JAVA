import java.util.Scanner;

public class PrintOneToN{
    static void f(int n){
        if (n < 1) {
            return;
        }
        f(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = in.nextInt();
        f(n);
    }
}