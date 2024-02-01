import java.util.Scanner;

public class reverseANumber {
    static void reverse(int n, int helper){
       if (n == 0) {
           System.out.println(helper);
           return;
       }
       int d = n % 10;
       helper = helper * 10 + d;
        reverse(n/10, helper);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number to find it's reverse:");
        int n = in.nextInt();
        reverse(n, 0);
    }
}
