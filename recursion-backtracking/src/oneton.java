import java.util.Scanner;

public class oneton {
    static void func( int n){
        if (n < 1){
            return;
        }

        func(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter a number");
            int n = in.nextInt();
            func(n);
        }
    }
}
