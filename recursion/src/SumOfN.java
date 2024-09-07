import java.util.Scanner;

public class SumOfN {
    static int f(int sum) {
        if (sum < 1)
            return 0;
        return sum + f(sum-1);
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
       int result = f(n);
        System.out.println(result);
    }
}
