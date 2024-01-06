import java.util.Scanner;

public class sumnto1 {
    static void sum(int i,int n){
        if (i < 1){
            System.out.println(n);
            return;
        }
        sum(i - 1, n + i);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number to find it's sum:");
        int n = in.nextInt();
        sum(n , 0);
    }
}
