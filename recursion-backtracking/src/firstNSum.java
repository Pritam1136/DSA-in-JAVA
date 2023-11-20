import java.util.Scanner;

public class firstNSum {
    static void Sum(int i, int sum){
        if (i < 1){
            System.out.println(sum);
            return;
        }
        Sum(i-1, sum+i);
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            Sum( n, 0);
        }
    }
}
