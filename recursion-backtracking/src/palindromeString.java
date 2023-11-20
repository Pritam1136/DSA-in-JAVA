import java.util.Scanner;

public class palindromeString {
    static boolean palindrome(String name, int i) {
        if (i >= (name.length() / 2)) {
            return true;
        }

        if (name.toUpperCase().charAt(i)!= name.toUpperCase().charAt(name.length() - i - 1)) {
            return false;
        }
        return palindrome(name, i+1);
    }
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String name;
            System.out.println("Enter the string :");
            name = in.next();
            boolean paling = palindrome(name, 0);
            if (paling){
                System.out.println("It is palindrome.");
            }else {
                System.out.println("It is not palindrome. ");
            }
        }
        }
}