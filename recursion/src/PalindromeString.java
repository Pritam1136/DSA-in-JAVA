import java.util.Scanner;

public class PalindromeString {
    static boolean palindrome(String st, int i, int n){
        if (i >= n/2)
            return true;
        if (st.charAt(i) != st.charAt(n -1 -i))
            return false;
        return palindrome(st, i+1, n);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string:");
        String st = in.next();
        boolean b = palindrome(st, 0, st.length());
        if (!b){
            System.out.println("String is not palindrome.");
        }
        else {
            System.out.println("String is palindrome.");
        }
    }
}
