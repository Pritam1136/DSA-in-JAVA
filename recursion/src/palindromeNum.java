import java.util.Scanner;

public class palindromeNum {
    static int palindrome(int a, int helper){
       if (a == 0){
           return helper;
       }
        int d = a % 10;
        helper = helper * 10 + d;
        return palindrome(a/10, helper);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int a = in.nextInt();
        int b = palindrome(a, 0);
        System.out.println(b);
        if (a != b) {
            System.out.println("Integer is not palindrome.");
        } else {
            System.out.println("Integer is palindrome.");
        }
    }
}
