import java.util.Scanner;

public class Main {
    static void func(int i, int n){
        if (i>n){
            return;
        }

        func(i+1, n);
        System.out.println(i);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = in.nextInt();
        func(1,n);
    }
}