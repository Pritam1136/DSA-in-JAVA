import java.util.Scanner;

public class fibonacci {
    static int series(int n){
        if (n <= 1){
            return n;
        }
        return series(n-1) +series(n-2);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i <= n; i++) {
            int sum = series(i);
            System.out.println(sum);
        }
    }
}
