import java.util.Scanner;

public class factorial {
    static int factorials(int f){
        if (f == 0){
            return 1;
        }
        return f * factorials(f - 1);
    }
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter a number to find it's factorial :");
            int f = in.nextInt();
            int factorial = factorials(f);
            System.out.println("Factorial : " +factorial);
        }
    }
}
